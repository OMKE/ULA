package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.SubjectAttendance;
import com.ula.faculty.dto.model.SubjectAttendanceDTO;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectAttendanceMapper
{
    public static SubjectAttendanceDTO map(SubjectAttendance subjectAttendance)
    {
        return new SubjectAttendanceDTO()
                    .setId(subjectAttendance.getId())
                    .setStudentId(subjectAttendance.getStudent().getStudentId())
                    .setSubjectRealizationId(subjectAttendance.getSubjectRealization().getId())
                    .setFinalGrade(subjectAttendance.getFinalGrade())
                    .setDeleted(subjectAttendance.isDeleted())
                    .setCreatedAt(subjectAttendance.getCreatedAt())
                    .setUpdatedAt(subjectAttendance.getUpdatedAt());
    }

    public static List<SubjectAttendanceDTO> map(List<SubjectAttendance> subjectAttendances)
    {
        return subjectAttendances.stream().map(SubjectAttendanceMapper::map).collect(Collectors.toList());
    }
}
