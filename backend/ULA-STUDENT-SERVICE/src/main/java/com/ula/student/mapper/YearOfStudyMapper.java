package com.ula.student.mapper;

import com.ula.student.dto.SubjectAttendanceWithSubjectDTO;
import com.ula.student.dto.SubjectWithRealizationIdDTO;
import com.ula.student.dto.YearOfStudyDTO;

import java.util.List;
import java.util.stream.Collectors;

public class YearOfStudyMapper
{
    public static YearOfStudyDTO map(List<SubjectAttendanceWithSubjectDTO> allSubjects, Long id)
    {
        List<SubjectAttendanceWithSubjectDTO> subjects =
        allSubjects.stream()
                .filter(subject -> subject.getSubject()
                                          .getYearOfStudyId()
                                          .equals(id))
                .map(subject ->
                             new SubjectAttendanceWithSubjectDTO()
                                     .setId(subject.getId())
                                     .setFinalGrade(subject.getFinalGrade())
                                     .setStudentId(subject.getStudentId())
                                     .setSubject
                                             (
                                                     new SubjectWithRealizationIdDTO()
                                                             .setId(subject.getSubject().getId())
                                                             .setSubjectRealizationId(subject.getSubject().getSubjectRealizationId())
                                                             .setYearOfStudyId(subject.getSubject().getYearOfStudyId())
                                                             .setEspb(subject.getSubject().getEspb())
                                                             .setName(subject.getSubject().getName())
                                                             .setNumberOfLectures(subject.getSubject().getNumberOfLectures())
                                                             .setNumberOfPracticalLectures(subject.getSubject().getNumberOfPracticalLectures())
                                                             .setOtherFormsOfLectures(subject.getSubject().getOtherFormsOfLectures())
                                                             .setResearchWorks(subject.getSubject().getResearchWorks())
                                                             .setOtherLectures(subject.getSubject().getOtherLectures())
                                                             .setSemester(subject.getSubject().getSemester())
                                                             .setRequired(subject.getSubject().isRequired())
                                             )
                    ).collect(Collectors.toList());

        Double averageGrade = subjects.stream().mapToDouble(subject -> subject.getFinalGrade() != null ? subject.getFinalGrade() : 0).sum() / subjects.size();
        int totalEspb = subjects.stream().mapToInt(subject -> subject.getSubject().getEspb()).sum();

        return new YearOfStudyDTO()
                .setId(id)
                .setSubjects(subjects)
                .setAverageGrade(averageGrade)
                .setTotalEspb(totalEspb);
    }
}
