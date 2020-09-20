package com.ula.teacher.api.v1.controller;

import com.ula.teacher.api.v1.request.UpdateSubjectAttendanceFinalGradeRequest;
import com.ula.teacher.service.exception.StudentOnYearNotFoundException;
import com.ula.teacher.service.exception.SubjectWithRealizationIdNotFoundException;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import com.ula.teacher.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;

import javax.validation.Valid;

@RestController
@Validated
public class SubjectController
{

    @Autowired
    private SubjectService subjectService;

    @Authorized("TEACHER")
    @GetMapping("/subject")
    public Response<Object> index()
    {
        return Response.ok().setPayload(this.subjectService.index());
    }

    @Authorized("TEACHER")
    @GetMapping("/subject/{id}")
    public Response<Object> show
            (
                    @PathVariable("id") Long subjectId
            )
    {
        try {
            return Response.ok().setPayload(this.subjectService.show(subjectId));
        } catch (SubjectWithRealizationIdNotFoundException | TeacherNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("TEACHER")
    @PutMapping("/subject/{subjectId}/student/{studentId}/final-grade")
    public Response<Object> updateFinalGrade
    (
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("studentId") Long studentId,
            @Valid @RequestBody UpdateSubjectAttendanceFinalGradeRequest request,
            Errors errors
    )
    {
        try {
            return this.subjectService.updateFinalGrade(subjectId, studentId, request);
        } catch (StudentOnYearNotFoundException | TeacherNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
