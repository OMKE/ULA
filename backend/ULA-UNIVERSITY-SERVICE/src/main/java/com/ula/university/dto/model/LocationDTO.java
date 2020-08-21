package com.ula.university.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class LocationDTO
{
    private Long id;
    private double longitude;
    private double latitude;
    private String name;
}
