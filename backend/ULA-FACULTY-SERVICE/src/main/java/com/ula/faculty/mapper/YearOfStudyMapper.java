package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.YearOfStudy;
import com.ula.faculty.dto.model.YearOfStudyDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class YearOfStudyMapper
{


    public static ArrayList<YearOfStudyDTO> map(List<YearOfStudy> yearOfStudies)
    {
        return yearOfStudies.stream().map(YearOfStudyMapper::map).collect(Collectors.toCollection(ArrayList::new));
    }

    public static YearOfStudyDTO map(YearOfStudy yearOfStudy)
    {
        return new YearOfStudyDTO()
                    .setId(yearOfStudy.getId())
                    .setOrdinalNumber(yearOfStudy.getOrdinalNumber())
                    .setStudyProgramId(yearOfStudy.getStudyProgram().getId())
                    .setCreated_at(yearOfStudy.getCreatedAt())
                    .setYear(yearOfStudy.getYear());
    }

}
