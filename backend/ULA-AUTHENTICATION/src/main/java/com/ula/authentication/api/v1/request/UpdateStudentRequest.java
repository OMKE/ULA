package com.ula.authentication.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateStudentRequest
{

    @Past(message = "Birth date should be in past")
    @NotNull(message = "Birth date is required")
    private Date dateOfBirth;

    @NotEmpty(message = "Phone number is required")
    @Size(min = 7, message = "Phone number can not be shorter than 7 digits")
    @Size(max = 15, message = "Phone number can not be longer than 15 digits")
    private String phoneNumber;

    @NotEmpty(message = "Social security number is required")
    @Size(min = 9, message = "Social security number has to be 9 characters long")
    @Size(max = 9, message = "Social security number has to be 9 characters long")
    private String ssn;

}
