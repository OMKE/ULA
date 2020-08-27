package com.ula.authentication.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUserPasswordRequest
{


    @NotEmpty(message = "Old password is required")
    @Size(min = 6, message = "Old password must be at least 5 characters long")
    @Size(max = 32, message = "Old password can not be longer than 32 characters")
    private String oldPassword;

    @NotEmpty(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 5 characters long")
    @Size(max = 32, message = "Password can not be longer than 32 characters")
    private String password;

    @NotEmpty(message = "Password confirmation is required")
    @Size(min = 6, message = "Confirmation password must be at least 6 characters long")
    @Size(max = 32, message = "Confirmation password can not be longer than 32 characters")
    private String confirmPassword;
}
