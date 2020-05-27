package com.ula.service.user;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ula.domain.model.EmailVerificationToken;
import com.ula.domain.model.User;
import com.ula.domain.repository.EmailVerificationTokenRepository;
import com.ula.dto.model.UserDTO;
import com.ula.service.exception.EmailVerificationTokenException;
import com.ula.service.exception.UserException;
import com.ula.util.RandomTokenGenerator;

@Service
public class EmailVerificationServiceImpl implements EmailVerificationService
{

	@Autowired
	private EmailVerificationTokenRepository emailVerificationRepo;

	@Autowired
	private UserService userService;

	@Override
	public boolean verify(String tokenToVerify, UserDTO userDTO)
			throws EmailVerificationTokenException
	{

		Optional<User> user;
		try
		{
			user = userService.getByUsername(userDTO.getUsername());
		} catch (UserException e)
		{
			throw new EmailVerificationTokenException(
					"User not found with corresponding verification token");
		}

		Optional<EmailVerificationToken> token = emailVerificationRepo.getByToken(tokenToVerify);
		if (token.isPresent())
		{
			if (this.isUsersToken(token.get(), user.get()))
			{

				if (this.isExpired(token.get()))
				{
					userService.verifyEmail(user.get());
					emailVerificationRepo.delete(token.get());
					return true;
				} else
				{
					throw new EmailVerificationTokenException("Verification token has expired");
				}

			} else
			{
				throw new EmailVerificationTokenException("Verification token is invalid");
			}
		} else
		{
			throw new EmailVerificationTokenException("Verification token is invalid");
		}

	}

	@Override
	public void generate(User user)
	{

		LocalDate days = LocalDate.now().plusDays(1);
		Date date = Date.from(days.atStartOfDay(ZoneId.systemDefault()).toInstant());

		EmailVerificationToken emailVerificationToken = new EmailVerificationToken().setUser(user)
				.setToken(RandomTokenGenerator.generate(128)).setExpiryDate(date);

		emailVerificationRepo.save(emailVerificationToken);


	}

	@Override
	public String resend(String username) throws EmailVerificationTokenException
	{
		Optional<User> user;
		try
		{
			user = userService.getByUsername(username);
			this.emailVerificationRepo.deleteByUser(user.get());
			this.generate(user.get());
			return "New confirmation link has been sent, check your emails";
		} catch (UserException e)
		{
			throw new EmailVerificationTokenException(
					"Unsuccessfull creation of confirmation link.");
		}
	}

	@Override
	public boolean isExpired(EmailVerificationToken token)
	{

		final Date expiration = token.getExpiryDate();
		if (expiration.before(new Date(System.currentTimeMillis())))
		{
			return false;
		} else
		{
			return true;
		}
	}

	@Override
	public boolean isUsersToken(EmailVerificationToken token, User user)
	{
		return user.getId() == token.getUser().getId();
	}

	@Override
	public boolean isTokenInDB(EmailVerificationToken token, String tokenToVerify)
	{
		return token.equals(tokenToVerify);
	}

}