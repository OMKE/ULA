package com.ula.university.api.v1.request;

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
public class PhoneNumberRequest
{
    @NotEmpty(message = "Contact info is required")
    @Size(min = 6, message = "Contact info must be at least 6 numbers long")
    @Size(min = 6, message = "Contact info must be at shorter than 32 characters")
    private String contactInfo;


    @NotEmpty(message = "Phone number is required")
    @Size(min = 6, message = "Phone number must be at least 6 numbers long")
    @Size(max = 32, message = "Phone number must be shorter than 32 numbers")
    private String phoneNumber;
}
