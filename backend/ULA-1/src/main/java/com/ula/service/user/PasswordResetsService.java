package com.ula.service.user;

import com.ula.domain.model.PasswordResets;
import com.ula.dto.model.PasswordResetsDTO;
import com.ula.service.exception.EmailNotFoundException;
import com.ula.service.exception.PasswordsDontMatchException;
import com.ula.service.exception.ResetPasswordTokenInvalidException;

public interface PasswordResetsService
{

	String sendResetEmail(PasswordResetsDTO passwordResetDTO) throws EmailNotFoundException;

	String verifyEmailToken(
			PasswordResetsDTO passwordResetDTO)
			throws ResetPasswordTokenInvalidException, PasswordsDontMatchException;

	boolean changeUserPassword(PasswordResets passwordReset, String newPassword);
}
