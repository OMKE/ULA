package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.StudentOnYear;
import com.ula.faculty.domain.model.SubjectAttendance;
import com.ula.faculty.domain.model.SubjectRealization;
import com.ula.faculty.dto.model.StudentDTO;
import com.ula.faculty.dto.model.StudentOnYearDTO;
import com.ula.faculty.dto.model.SubjectAttendanceDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

    public static StudentOnYearDTO map(StudentDTO studentDTO, StudentOnYear studentOnYear)
    {
        return StudentOnYearMapper.map(studentOnYear).setStudent(studentDTO).setStudentId(null);
    }

    public static List<StudentOnYearDTO> map(List<StudentOnYear> studentOnYears)
    {
        return studentOnYears
                .stream()
                .map(StudentOnYearMapper::map).collect(Collectors.toList());
    }

    public static List<StudentOnYearDTO> map(List<StudentDTO> studentDTOS, List<StudentOnYear> studentOnYears)
    {
        ArrayList<StudentOnYearDTO> students = new ArrayList<>();

        for(StudentDTO studentDTO: studentDTOS)
        {
            for(StudentOnYear studentOnYear: studentOnYears)
            {
                if(studentDTO.getId().equals(studentOnYear.getStudentId()) && !studentOnYear.isDeleted())
                {
                    students.add
                            (
                                    new StudentOnYearDTO()
                                            .setId(studentOnYear.getId())
                                            .setStudent(studentDTO)
                                            .setDateOfEnrollment(studentOnYear.getDateOfEnrollment())
                                            .setTranscriptIdentifier(studentOnYear.getTranscriptIdentifier())
                                            .setYearOfStudyIds(
                                                    studentOnYear.getYearOfStudies()
                                                                 .stream()
                                                                 .mapToLong(year ->
                                                                                    year.getYearOfStudy().getId())
                                                                 .boxed()
                                                                 .collect(Collectors.toList()))
                            );
                }
            }
        }
        return students;
    }

    public static List<StudentOnYearDTO> map(List<StudentDTO> studentDTOS, List<StudentOnYear> studentOnYears, SubjectRealization subjectRealization)
    {
        ArrayList<StudentOnYearDTO> students = new ArrayList<>();

        for(StudentDTO studentDTO: studentDTOS)
        {
            for(StudentOnYear studentOnYear: studentOnYears)
            {
                if(studentDTO.getId().equals(studentOnYear.getStudentId()) && !studentOnYear.isDeleted())
                {
                    students.add
                            (
                                    new StudentOnYearDTO()
                                            .setId(studentOnYear.getId())
                                            .setStudent(studentDTO)
                                            .setDateOfEnrollment(studentOnYear.getDateOfEnrollment())
                                            .setTranscriptIdentifier(studentOnYear.getTranscriptIdentifier())
                                            .setYearOfStudyIds(
                                                    studentOnYear.getYearOfStudies()
                                                                 .stream()
                                                                 .mapToLong(year ->
                                                                                    year.getYearOfStudy().getId())
                                                                 .boxed()
                                                                 .collect(Collectors.toList()))
                                            .setAttendance(StudentOnYearMapper.mapAttendance(studentOnYear.getSubjectAttendances(), subjectRealization))
                            );
                }
            }
        }
        return students;
    }

    public static SubjectAttendanceDTO mapAttendance(Set<SubjectAttendance> attendances, SubjectRealization subjectRealization)
    {
        SubjectAttendanceDTO subjectAttendanceDTO = new SubjectAttendanceDTO();
        for(SubjectAttendance attendance: attendances)
        {
            if(attendance.getSubjectRealization().getId().equals(subjectRealization.getId()))
            {
                subjectAttendanceDTO
                        .setId(attendance.getId())
                        .setSubjectRealizationId(subjectRealization.getId())
                        .setStudentId(attendance.getStudent().getId())
                        .setFinalGrade(attendance.getFinalGrade() != null ? attendance.getFinalGrade() : 0);
            }
        }
        return subjectAttendanceDTO;
    }
}
