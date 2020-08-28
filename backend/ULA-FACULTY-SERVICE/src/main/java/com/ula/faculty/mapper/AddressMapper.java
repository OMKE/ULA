package com.ula.faculty.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ula.faculty.dto.model.AddressDTO;

public class AddressMapper
{

    public static AddressDTO map(Object address)
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(address, new TypeReference<AddressDTO>() {});
    }
}
