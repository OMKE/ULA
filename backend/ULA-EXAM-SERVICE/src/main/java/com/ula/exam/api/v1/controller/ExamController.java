package com.ula.exam.api.v1.controller;

import com.ula.exam.api.v1.request.StoreExamRequest;
import com.ula.exam.api.v1.request.UpdateExamRequest;
import com.ula.exam.dto.model.ExamDTO;
import com.ula.exam.service.exam.ExamService;
import com.ula.exam.service.exception.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.annotation.Token;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;
import org.ula.core.util.JWT;

import javax.validation.Valid;

@RestController
@Validated
public class ExamController extends BaseController
{
    @Autowired
    private ExamService examService;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Authorized("[ADMIN,TEACHER]")
    @GetMapping("/exam")
    public Response<Object> index
    (
            @Token JWT jwt
    )
    {
        return Response.ok()
                       .setPayload(this.examService.index());
    }

    @Authorized("[ADMIN,TEACHER]")
    @GetMapping("/exam/{id}")
    public Response<Object> show
    (
            @Token JWT jwt,
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok()
                           .setPayload(this.examService.show(id));
        } catch (ExamNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("STUDENT")
    @GetMapping("/private/taking-exam/subject-attendance/{studentId}/{subjectAttendanceId}/{examId}")
    public ExamDTO showByStudentIdSubjectAttendanceIdAndExamId
    (
        @Token JWT jwt,
        @PathVariable("studentId") Long studentId,
        @PathVariable("subjectAttendanceId") Long subjectAttendanceId,
        @PathVariable("examId") Long examId
    )
    {
        try {
            return this.examService.showBySubjectIdAndSubjectAttendanceId(studentId, subjectAttendanceId, examId);
        } catch (TakingExamNotFoundException | ExamNotFoundException e) {
            return null;
        }
    }
    
    @Authorized("[ADMIN,TEACHER]")
    @PostMapping("exam")
    public Response<Object> store
    (
        @Token JWT jwt,
        @Valid @RequestBody StoreExamRequest storeRequest,
        Errors errors
    )
    {
        ExamDTO examDTO = new ExamDTO()
                    .setExamTypeId(storeRequest.getTypeId())
                    .setTakingExamId(storeRequest.getTakingExamId())
                    .setStartTime(storeRequest.getStartTime())
                    .setEndTime(storeRequest.getEndTime())
                    .setFinalExam(storeRequest.isFinalExam())
                    .setExamTermId(storeRequest.getExamTermId());

        try {
            return Response.ok()
                           .setPayload(this.examService.store(examDTO));
        } catch (TakingExamNotFoundException | ExamTypeNotFoundException | ExamTermNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
    
    @Authorized("[ADMIN,TEACHER]")
    @PutMapping("/exam/{id}")
    public Response<Object> update
    (
        @Token JWT jwt,
        @Valid @RequestBody UpdateExamRequest updateRequest,
        @PathVariable("id") Long id,
        Errors errors
    )
    {
        updateRequest.setDescription(this.sanitize(updateRequest.getDescription()));

        try {
            return Response.ok()
                           .setPayload(this.examService.update(id, updateRequest));
        } catch (ExamNotFoundException | ExamDoesNotHaveActiveEntryException | ExamDoesNotHaveEntry e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
    
    @Authorized("[ADMIN,TEACHER]")
    @DeleteMapping("/exam/{id}")
    public Response<Object> delete
    (
        @Token JWT jwt,
        @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok()
                           .setPayload(this.examService.delete(id));
        } catch (ExamNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @GetMapping("/test")
    public String test(@RequestParam("message") String message)
    {
        rabbitTemplate.convertAndSend("ula-queue", "ula.test.baz", message);

        return message;
    }
}
