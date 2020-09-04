package com.ula.exam.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ula.exam.dto.model.SubjectAttendanceDTO;

public class SubjectAttendanceDTOMapper
{
    public static SubjectAttendanceDTO map(Object object)
    {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.convertValue(object, new TypeReference<SubjectAttendanceDTO>() {});
    }
}
