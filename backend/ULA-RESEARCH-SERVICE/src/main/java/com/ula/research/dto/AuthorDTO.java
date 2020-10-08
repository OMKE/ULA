package com.ula.research.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class AuthorDTO
{
    private Long id;
    private String firstName;
    private String lastName;
}
