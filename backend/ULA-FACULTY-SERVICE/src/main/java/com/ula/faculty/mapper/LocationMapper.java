package com.ula.faculty.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ula.faculty.dto.model.LocationDTO;

public class LocationMapper
{

    public static LocationDTO map(Object object)
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(object, new TypeReference<LocationDTO>() {});
    }
}
