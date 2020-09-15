package com.ula.faculty.api.v1.controller;

import com.ula.faculty.dto.model.StudentDTO;
import com.ula.faculty.dto.model.SubjectWithRealizationIdDTO;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.SubjectRealizationNotFoundException;
import com.ula.faculty.service.exception.TeacherOnRealizationNotFoundException;
import com.ula.faculty.service.exception.TeacherSubjectRealizationNotFoundException;
import com.ula.faculty.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;

import java.util.List;

@RestController
public class TeacherSubjectRealizationController
{
    @Autowired
    private TeacherService teacherService;


    @Authorized("TEACHER")
    @GetMapping("/private/teacher/{id}/subject")
    public List<SubjectWithRealizationIdDTO> subjects
    (
            @PathVariable("id") Long teacherId
    )
    {
        try {
            return this.teacherService.subjects(teacherId);
        } catch (TeacherOnRealizationNotFoundException e) {
            return null;
        }
    }

    @Authorized("TEACHER")
    @GetMapping("/private/teacher/{teacherId}/subject/{subjectId}")
    public SubjectWithRealizationIdDTO show
    (
            @PathVariable("teacherId") Long teacherId,
            @PathVariable("subjectId") Long subjectId
    )
    {
        try {
            return this.teacherService.subject(teacherId, subjectId);
        } catch (SubjectNotFoundException | TeacherOnRealizationNotFoundException | TeacherSubjectRealizationNotFoundException e) {
            return null;
        }
    }
    @Authorized("TEACHER")
    @GetMapping("/private/teacher/subject/{subjectId}/student")
    public List<StudentDTO> students
    (
            @PathVariable("subjectId") Long subjectId,
            Pageable pageable
    )
    {
        try {
            return this.teacherService.students(subjectId, pageable);
        } catch (SubjectRealizationNotFoundException e) {
            return null;
        }
    }
}
