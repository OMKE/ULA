package com.ula.faculty.api.v1.request;

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
public class StoreTeachingMaterialAuthorRequest
{

    @NotEmpty(message = "First name is required")
    @Size(min = 3, message = "First name has to be at least 3 characters long")
    @Size(max = 128, message = "First name can not be longer than 128 charcaters")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Size(min = 3, message = "Last name has to be at least 3 characters long")
    @Size(max = 128, message = "Last name can not be longer than 128 charcaters")
    private String lastName;

}
