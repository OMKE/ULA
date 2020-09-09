package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.SubjectAttendance;

import com.ula.faculty.dto.model.SubjectAttendanceWithSubjectDTO;
import com.ula.faculty.dto.model.SubjectWithRealizationIdDTO;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectAttendanceWithSubjectMapper
{
    public static SubjectAttendanceWithSubjectDTO map(SubjectAttendance subjectAttendance)
    {
        return new SubjectAttendanceWithSubjectDTO()
                    .setId(subjectAttendance.getId())
                    .setFinalGrade(subjectAttendance.getFinalGrade())
                    .setStudentId(subjectAttendance.getStudent().getId())
                    .setSubject
                            (
                                new SubjectWithRealizationIdDTO()
                                    .setId(subjectAttendance.getSubjectRealization().getSubject().getId())
                                    .setSubjectRealizationId(subjectAttendance.getSubjectRealization().getId())
                                    .setEspb(subjectAttendance.getSubjectRealization().getSubject().getEspb())
                                    .setName(subjectAttendance.getSubjectRealization().getSubject().getName())
                                    .setNumberOfLectures(subjectAttendance.getSubjectRealization().getSubject().getNumberOfLectures())
                                    .setNumberOfPracticalLectures(subjectAttendance.getSubjectRealization().getSubject().getNumberOfPracticalLectures())
                                    .setOtherFormsOfLectures(subjectAttendance.getSubjectRealization().getSubject().getOtherFormsOfLectures())
                                    .setOtherLectures(subjectAttendance.getSubjectRealization().getSubject().getOtherLectures())
                                    .setResearchWorks(subjectAttendance.getSubjectRealization().getSubject().getResearchWorks())
                                    .setSemester(subjectAttendance.getSubjectRealization().getSubject().getSemester())
                                    .setRequired(subjectAttendance.getSubjectRealization().getSubject().isRequired())
                                    .setYearOfStudyId(subjectAttendance.getSubjectRealization().getSubject().getYearOfStudy().getId())
                            );
    }

    public static List<SubjectAttendanceWithSubjectDTO> map(List<SubjectAttendance> subjectAttendances)
    {
        return subjectAttendances.stream().map(SubjectAttendanceWithSubjectMapper::map).collect(Collectors.toList());
    }
}
