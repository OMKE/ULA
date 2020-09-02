package com.ula.faculty.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ula.faculty.dto.model.StudentDTO;

public class StudentDTOMapper
{
    public static StudentDTO map(Object object)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(object, new TypeReference<StudentDTO>() {});
    }
}
