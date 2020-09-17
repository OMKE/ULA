package com.ula.teacher.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class TeachingMaterialAuthorDTO
{
    private Long id;
    private Long teachingMaterialId;
    private String firstName;
    private String lastName;
}
