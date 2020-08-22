package com.ula.university.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressRequest
{
    @NotNull(message = "City id is required")
    private Long cityId;

    @NotEmpty(message = "Street name is required")
    @Size(min = 6, message = "Street name has to be at least 6 characters long")
    @Size(max = 255, message = "Street name can not be longer than 255 characters")
    private String streetName;


    @NotEmpty(message = "Number is required")
    @Size(max = 255, message = "Number can not be longer than 63 characters")
    private String number;


    @NotEmpty(message = "Postal code is required")
    @Size(min = 4, message = "Postal code has to be at least 4 characters long")
    @Size(max = 255, message = "Postal code can not be longer than 63 characters")
    private String postalCode;

}
