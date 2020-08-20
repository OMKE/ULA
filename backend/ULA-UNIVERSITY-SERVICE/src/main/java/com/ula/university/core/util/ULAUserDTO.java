package com.ula.university.core.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ULAUserDTO
{
    private Long id;
    private String username;
    private ArrayList<String> roles;
}
