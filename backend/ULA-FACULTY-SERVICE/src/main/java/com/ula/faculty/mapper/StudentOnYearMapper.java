package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.StudentOnYear;
import com.ula.faculty.dto.model.StudentOnYearDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StudentOnYearMapper
{

    public static StudentOnYearDTO map(StudentOnYear studentOnYear)
    {
        return new StudentOnYearDTO()
                .setId(studentOnYear.getId())
                .setStudentId(studentOnYear.getStudentId())
                .setYearOfStudyIds(studentOnYear.getYearOfStudies()
                                                .stream()
                                                .map(studentOnYearYearOfStudy -> studentOnYearYearOfStudy.getYearOfStudy().getId())
                                                .collect(Collectors.toList()))
                .setTranscriptIdentifier(studentOnYear.getTranscriptIdentifier())
                .setDateOfEnrollment(studentOnYear.getDateOfEnrollment())
                .setDeleted(studentOnYear.isDeleted())
                .setCreatedAt(studentOnYear.getCreatedAt())
                .setUpdatedAt(studentOnYear.getUpdatedAt());
    }

    public static List<StudentOnYearDTO> map(List<StudentOnYear> studentOnYears)
    {
        return studentOnYears
                .stream()
                .map(StudentOnYearMapper::map).collect(Collectors.toList());
    }
}
