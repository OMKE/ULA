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
public class UpdateUserFirstAndLastNameRequest
{

    @Size(min = 3, message = "First name must be at least 3 characters long")
    @Size(max = 64, message = "First name can not be longer than 64 characters")
    @NotEmpty(message = "First name is required")
    private String firstName;


    @Size(min = 3, message = "Last name must be at least 3 characters long")
    @Size(max = 64, message = "Last name can not be longer than 64 characters")
    @NotEmpty(message = "Last name is required")
    private String lastName;

}
