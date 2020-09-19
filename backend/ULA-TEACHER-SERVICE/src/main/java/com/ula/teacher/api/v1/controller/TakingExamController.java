package com.ula.teacher.api.v1.controller;

import com.ula.teacher.api.v1.request.UpdateTakingExamRequest;
import com.ula.teacher.service.exception.SubjectAttendanceNotFoundException;
import com.ula.teacher.service.exception.TakingExamNotFoundException;
import com.ula.teacher.service.takingexam.TakingExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;

import javax.validation.Valid;

@RestController
@Validated
public class TakingExamController
{
    @Autowired
    private TakingExamService takingExamService;


    @Authorized("TEACHER")
    @PutMapping("/subject/{subjectId}/student/{studentId}/taking-exam")
    public Response<Object> update
    (
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("studentId") Long studentId,
            @Valid @RequestBody UpdateTakingExamRequest request,
            Errors errors
    )
    {
        try {
            return this.takingExamService.update(subjectId, studentId, request);
        } catch (SubjectAttendanceNotFoundException | TakingExamNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("TEACHER")
    @GetMapping("/subject/{subjectId}/student/{studentId}/taking-exam")
    public Response<Object> show
            (
                    @PathVariable("subjectId") Long subjectId,
                    @PathVariable("studentId") Long studentId
            )
    {
        try {
            return Response.ok().setPayload(this.takingExamService.show(subjectId, studentId));
        } catch (SubjectAttendanceNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }


    @Authorized("TEACHER")
    @GetMapping("/subject/{subjectId}/student/{studentId}/taking-exam/point")
    public Response<Object> points
            (
                    @PathVariable("subjectId") Long subjectId,
                    @PathVariable("studentId") Long studentId
            )
    {
        try {
            return Response.ok().setPayload(this.takingExamService.getTakingExamPointsCalculated(subjectId, studentId));
        } catch (SubjectAttendanceNotFoundException | TakingExamNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
