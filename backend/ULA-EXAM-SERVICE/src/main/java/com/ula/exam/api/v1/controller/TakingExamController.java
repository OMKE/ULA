package com.ula.exam.api.v1.controller;

import com.ula.exam.api.v1.request.CreateExamsRequest;
import com.ula.exam.api.v1.request.StoreTakingExamRequest;
import com.ula.exam.api.v1.request.UpdateTakingExamRequest;
import com.ula.exam.dto.model.TakingExamDTO;
import com.ula.exam.service.exception.*;
import com.ula.exam.service.points.PointsService;
import com.ula.exam.service.takingexam.TakingExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;
import org.ula.core.util.JWTUtil;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class TakingExamController extends BaseController
{
    @Autowired
    private TakingExamService takingExamService;

    @Autowired
    private PointsService pointsService;

    @Autowired
    private JWTUtil jwtUtil;

    @Authorized("[ADMIN,TEACHER]")
    @GetMapping("/taking-exam")
    public Response<Object> index()
    {
        return Response.ok()
                       .setPayload(this.takingExamService.index());
    }

    @Authorized("[ADMIN,TEACHER]")
    @GetMapping("/taking-exam/{id}")
    public Response<Object> show
    (
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

    @Authorized("STUDENT")
    @GetMapping("/private/taking-exam/subject-attendance/{studentId}/{id}")
    public TakingExamDTO showBySubjectAttendanceId
            (
                    @PathVariable("studentId") Long studentId,
                    @PathVariable("id") Long id
            )
    {

        try {
            return this.takingExamService.showByStudentIdAndSubjectAttendanceId(studentId, id);
        } catch (TakingExamNotFoundException e) {
            return null;
        }

    }

    @Authorized("TEACHER")
    @GetMapping("/private/teacher/taking-exam/subject-attendance/{id}")
    public TakingExamDTO showBySubjectAttendanceId
    (
            @PathVariable("id") Long subjectAttendanceId
    )
    {
        try {
            return this.takingExamService.showBySubjectAttendanceId(subjectAttendanceId);
        } catch (TakingExamNotFoundException e) {
            return null;
        }
    }


    @Authorized("[ADMIN,TEACHER]")
    @GetMapping("/taking-exam/{id}/points")
    public Response<Object> showPoints
    (
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
            @Valid @RequestBody StoreTakingExamRequest storeRequest,
            Errors errors
    )
    {
        TakingExamDTO takingExamDTO = new TakingExamDTO()
                    .setNote(this.sanitize(storeRequest.getNote()))
                    .setSubjectAttendanceId(storeRequest.getSubjectAttendanceId());

        try {
            return Response.ok()
                           .setPayload(this.takingExamService.store(takingExamDTO, jwtUtil.getToken()));
        } catch (SubjectAttendanceNotFoundException | SubjectAttendanceConflictException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @PostMapping("/private/taking-exam")
    public Response<Object> storeMany
            (
                    @Valid @RequestBody List<StoreTakingExamRequest> requests
            )
    {
        return Response.ok().setPayload(this.takingExamService.store(requests));
    }


    @Authorized("TEACHER")
    @PostMapping("/private/create-exam")
    public Response<Object> createExams
    (
            @Valid @RequestBody CreateExamsRequest request,
            Errors errors
    )
    {
        try {
            return Response.ok().setPayload(this.takingExamService.createExams(request.getSubjectAttendanceIds(), request.getExamDTO()));
        } catch (TakingExamNotFoundException | ExamTypeNotFoundException | ExamTermNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }




    @Authorized("[ADMIN,TEACHER]")
    @PutMapping("/taking-exam/{id}")
    public Response<Object> update
    (
            @Valid @RequestBody UpdateTakingExamRequest updateRequest,
            @PathVariable("id") Long id,
            Errors errors
    )
    {
        TakingExamDTO takingExamDTO = new TakingExamDTO()
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
