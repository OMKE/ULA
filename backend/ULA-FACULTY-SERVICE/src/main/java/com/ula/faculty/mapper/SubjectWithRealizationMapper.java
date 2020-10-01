package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.TeacherSubjectRealization;
import com.ula.faculty.dto.model.SubjectSyllabusDTO;
import com.ula.faculty.dto.model.SubjectWithRealizationIdDTO;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubjectWithRealizationMapper
{
    public static SubjectWithRealizationIdDTO map(TeacherSubjectRealization teacherSubjectRealization)
    {
        return new SubjectWithRealizationIdDTO()
                    .setId(teacherSubjectRealization.getSubjectRealization().getSubject().getId())
                    .setEspb(teacherSubjectRealization.getSubjectRealization().getSubject().getEspb())
                    .setName(teacherSubjectRealization.getSubjectRealization().getSubject().getName())
                    .setNumberOfLectures(teacherSubjectRealization.getSubjectRealization().getSubject().getNumberOfLectures())
                    .setNumberOfPracticalLectures(teacherSubjectRealization.getSubjectRealization().getSubject().getNumberOfPracticalLectures())
                    .setOtherFormsOfLectures(teacherSubjectRealization.getSubjectRealization().getSubject().getOtherFormsOfLectures())
                    .setOtherLectures(teacherSubjectRealization.getSubjectRealization().getSubject().getOtherLectures())
                    .setRequired(teacherSubjectRealization.getSubjectRealization().getSubject().isRequired())
                    .setResearchWorks(teacherSubjectRealization.getSubjectRealization().getSubject().getResearchWorks())
                    .setSemester(teacherSubjectRealization.getSubjectRealization().getSubject().getSemester())
                    .setSubjectRealizationId(teacherSubjectRealization.getSubjectRealization().getId())
                    .setYearOfStudyId(teacherSubjectRealization.getSubjectRealization().getSubject().getYearOfStudy().getId())
                    .setSyllabus(
                            new SubjectSyllabusDTO()
                                    .setId(teacherSubjectRealization.getSubjectRealization().getSubject().getSyllabus().getId())
                                    .setSubjectId(teacherSubjectRealization.getSubjectRealization().getSubject().getId())
                                    .setContent(teacherSubjectRealization.getSubjectRealization().getSubject().getSyllabus().getContent())
                                );
    }

    public static List<SubjectWithRealizationIdDTO> map(Set<TeacherSubjectRealization> teacherSubjectRealizations)
    {
        return teacherSubjectRealizations.stream().map(SubjectWithRealizationMapper::map).sorted(
                Comparator.comparingLong(SubjectWithRealizationIdDTO::getId)).collect(Collectors.toList());
    }
}
