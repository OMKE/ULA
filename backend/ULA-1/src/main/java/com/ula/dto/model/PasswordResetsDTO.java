package com.ula.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class PasswordResetsDTO
{
	private String email;
	private String token;
	private String newPassword;
	private String confirmPassword;

}
