package com.ula.university.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ImageDTO
{
    private Long id;
    private Long albumId;
    private String path;
    private String description;
    private String name;

}
