package com.ula.university.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ula.university.domain.model.Faculty;

import java.util.ArrayList;

public class FacultyMapper
{

    public static ArrayList<Faculty> mapFaculties(Object faculties)
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(faculties, new TypeReference<ArrayList<Faculty>>() {});
    }
}
