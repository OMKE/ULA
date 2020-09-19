package com.ula.teacher.api.v1.controller;

import com.ula.teacher.api.v1.request.StoreExamRequest;
import com.ula.teacher.api.v1.request.UpdateExamRequest;
import com.ula.teacher.dto.ExamDTO;
import com.ula.teacher.service.exam.ExamService;
import com.ula.teacher.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;

import javax.validation.Valid;

@RestController
@Validated
public class ExamController
{
    @Autowired
    private ExamService examService;

    @Authorized("TEACHER")
    @PostMapping("/subject/{subjectId}/exam")
    public Response<Object> store
            (
                    @PathVariable("subjectId") Long subjectId,
                    @Valid @RequestBody StoreExamRequest request,
                    Errors errors
            )
    {


        ExamDTO examDTO = new ExamDTO()
                .setExamTypeId(request.getTypeId())
                .setStartTime(request.getStartTime())
                .setEndTime(request.getEndTime())
                .setFinalExam(request.isFinalExam())
                .setExamTermId(request.getExamTermId());

        try {
            return this.examService.store(subjectId,examDTO);
        } catch (SubjectAttendancesNotFoundException | TeacherNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("TEACHER")
    @GetMapping("/subject/{subjectId}/student/{studentId}/taking-exam/exam/{examId}")
    public Response<Object> show
    (
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("studentId") Long studentId,
            @PathVariable("examId") Long examId
    )
    {
        try {
            return Response.ok().setPayload(this.examService.show(subjectId, studentId, examId));
        } catch (SubjectAttendanceNotFoundException | ExamNotFoundException | TakingExamNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }



    @Authorized("TEACHER")
    @PutMapping("/subject/{subjectId}/student/{studentId}/taking-exam/exam/{examId}")
    public Response<Object> update
    (
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("studentId") Long studentId,
            @PathVariable("examId") Long examId,
            @Valid @RequestBody UpdateExamRequest request,
            Errors errors
    )
    {
        try {
            return this.examService.update(subjectId, studentId, examId, request);
        } catch (SubjectAttendanceNotFoundException | ExamNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }


}
