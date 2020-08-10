package com.ula.authentication.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ULAUserDTO
{
    private Long id;
    private String username;
    private ArrayList<String> roles;
}
