package org.ula.core.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class UserDTO
{
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String profileImage;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private String termsAndConditions;


}
