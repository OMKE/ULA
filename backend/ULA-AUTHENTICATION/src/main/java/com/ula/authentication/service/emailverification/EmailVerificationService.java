package com.ula.authentication.service.emailverification;


import com.ula.authentication.domain.model.EmailVerificationToken;
import com.ula.authentication.domain.model.User;
import com.ula.authentication.service.exception.EmailVerificationTokenException;
import org.ula.core.domain.model.UserDTO;

public interface EmailVerificationService
{

	boolean verify(String token, UserDTO userDTO) throws EmailVerificationTokenException;

	boolean isUsersToken(EmailVerificationToken token, User user);

	boolean isTokenInDB(EmailVerificationToken token, String tokenToVerify);

	void generate(User user);

	boolean isExpired(EmailVerificationToken token);

	String resend(String username) throws EmailVerificationTokenException;
}
