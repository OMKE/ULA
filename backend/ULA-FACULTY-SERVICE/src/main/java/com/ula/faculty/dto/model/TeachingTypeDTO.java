package com.ula.faculty.dto.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class TeachingTypeDTO
{
    private Long id;
    private String name;
}
