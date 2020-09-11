package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.Subject;
import com.ula.faculty.dto.model.SubjectDTO;
import com.ula.faculty.dto.model.SubjectSyllabusDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubjectMapper
{
    public static SubjectDTO map(Subject subject)
    {
        return new SubjectDTO()
                    .setId(subject.getId())
                    .setName(subject.getName())
                    .setEspb(subject.getEspb())
                    .setNumberOfLectures(subject.getNumberOfLectures())
                    .setNumberOfPracticalLectures(subject.getNumberOfPracticalLectures())
                    .setOtherLectures(subject.getOtherLectures())
                    .setOtherFormsOfLectures(subject.getOtherFormsOfLectures())
                    .setRequired(subject.isRequired())
                    .setResearchWorks(subject.getResearchWorks())
                    .setSemester(subject.getSemester())
                    .setYearOfStudyId(subject.getYearOfStudy().getId())
                    .setSyllabus(
                            new SubjectSyllabusDTO()
                                .setId(subject.getSyllabus().getId())
                                .setSubjectId(subject.getId())
                                .setContent(subject.getSyllabus().getContent())
                                          );
    }

    public static ArrayList<SubjectDTO> map(List<Subject> subjects)
    {
        return subjects.stream().map(SubjectMapper::map).collect(Collectors.toCollection(ArrayList::new));
    }

}
