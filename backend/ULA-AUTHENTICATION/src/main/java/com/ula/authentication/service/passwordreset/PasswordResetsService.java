package com.ula.authentication.service.user;


import com.ula.authentication.domain.model.PasswordResets;
import com.ula.authentication.dto.model.PasswordResetsDTO;
import com.ula.authentication.service.exception.EmailNotFoundException;
import com.ula.authentication.service.exception.PasswordsDontMatchException;
import com.ula.authentication.service.exception.ResetPasswordTokenInvalidException;

public interface PasswordResetsService
{

	String sendResetEmail(PasswordResetsDTO passwordResetDTO) throws EmailNotFoundException;

	String verifyEmailToken(
			PasswordResetsDTO passwordResetDTO)
			throws ResetPasswordTokenInvalidException, PasswordsDontMatchException;

	boolean changeUserPassword(PasswordResets passwordReset, String newPassword);
}
