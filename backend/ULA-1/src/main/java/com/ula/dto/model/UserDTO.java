package com.ula.dto.model;

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
	private String password;
    private String email;
    private String profileImage;
    private String firstName;
    private String lastName;
    
    
}