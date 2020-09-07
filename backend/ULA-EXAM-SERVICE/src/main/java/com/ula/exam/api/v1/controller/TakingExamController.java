package com.ula.exam.api.v1.controller;

import com.ula.exam.api.v1.request.StoreTakingExamRequest;
import com.ula.exam.api.v1.request.UpdateTakingExamRequest;
import com.ula.exam.dto.model.TakingExamDTO;
import com.ula.exam.service.exception.FinalExamNotFoundException;
import com.ula.exam.service.exception.SubjectAttendanceConflictException;
import com.ula.exam.service.exception.SubjectAttendanceNotFoundException;
import com.ula.exam.service.exception.TakingExamNotFoundException;
import com.ula.exam.service.points.PointsService;
import com.ula.exam.service.takingexam.TakingExamService;
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
public class TakingExamController extends BaseController
{
    @Autowired
    private TakingExamService takingExamService;

    @Autowired
    private PointsService pointsService;

    @Authorized("[ADMIN,TEACHER]")
    @GetMapping("/taking-exam")
    public Response<Object> index
    (
            @Token JWT jwt
    )
    {
        return Response.ok()
                       .setPayload(this.takingExamService.index());
    }

    @Authorized("[ADMIN,TEACHER]")
    @GetMapping("/taking-exam/{id}")
    public Response<Object> show
    (
            @Token JWT jwt,
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok()
                           .setPayload(this.takingExamService.show(id));
        } catch (TakingExamNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("[ADMIN,TEACHER]")
    @GetMapping("/taking-exam/{id}/points")
    public Response<Object> showPoints
    (
            @Token JWT jwt,
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok().setPayload(this.pointsService.getByTakingExamId(id));
        } catch (TakingExamNotFoundException | FinalExamNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("[ADMIN,TEACHER]")
    @PostMapping("/taking-exam")
    public Response<Object> store
    (
            @Token JWT jwt,
            @Valid @RequestBody StoreTakingExamRequest storeRequest,
            Errors errors
    )
    {
        TakingExamDTO takingExamDTO = new TakingExamDTO()
                    .setNote(this.sanitize(storeRequest.getNote()))
                    .setSubjectAttendanceId(storeRequest.getSubjectAttendanceId());

        try {
            return Response.ok()
                           .setPayload(this.takingExamService.store(takingExamDTO, jwt.getContent()));
        } catch (SubjectAttendanceNotFoundException | SubjectAttendanceConflictException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("[ADMIN,TEACHER]")
    @PutMapping("/taking-exam/{id}")
    public Response<Object> update
    (
            @Token JWT jwt,
            @Valid @RequestBody UpdateTakingExamRequest updateRequest,
            @PathVariable("id") Long id,
            Errors errors
    )
    {
        TakingExamDTO takingExamDTO = new TakingExamDTO()
                    .setNote(this.sanitize(updateRequest.getNote()))
                    .setPoints(updateRequest.getPoints());

        try {
            return Response.ok()
                           .setPayload(this.takingExamService.update(id, takingExamDTO));
        } catch (TakingExamNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @DeleteMapping("/taking-exam/{id}")
    public Response<Object> delete
    (
            @Token JWT jwt,
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok()
                           .setPayload(this.takingExamService.delete(id));
        } catch (TakingExamNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
