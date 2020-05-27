package com.ula.service.user;

import com.ula.domain.model.EmailVerificationToken;
import com.ula.domain.model.User;
import com.ula.dto.model.UserDTO;
import com.ula.service.exception.EmailVerificationTokenException;

public interface EmailVerificationService
{

	boolean verify(String token, UserDTO userDTO) throws EmailVerificationTokenException;

	boolean isUsersToken(EmailVerificationToken token, User user);

	boolean isTokenInDB(EmailVerificationToken token, String tokenToVerify);

	void generate(User user);

	boolean isExpired(EmailVerificationToken token);

	String resend(String username) throws EmailVerificationTokenException;
}
