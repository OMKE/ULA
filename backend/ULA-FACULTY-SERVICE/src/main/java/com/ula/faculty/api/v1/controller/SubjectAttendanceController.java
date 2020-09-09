package com.ula.faculty.api.v1.controller;

import com.ula.faculty.dto.model.SubjectAttendanceWithSubjectDTO;
import com.ula.faculty.service.exception.SubjectAttendanceNotFoundException;
import com.ula.faculty.service.subjectattendance.SubjectAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;
import org.ula.core.annotation.Token;
import org.ula.core.api.response.Response;
import org.ula.core.util.JWT;

import java.util.List;

@RestController
@Validated
public class SubjectAttendanceController
{
    @Autowired
    private SubjectAttendanceService subjectAttendanceService;


    @Authorized("[ADMIN,TEACHER]")
    @GetMapping("/subject-attendance")
    public Response<Object> index
    (
        @Token JWT jwt
    )
    {
        return Response.ok()
                       .setPayload(this.subjectAttendanceService.index());
    }

    @Authorized("[ADMIN,TEACHER]")
    @GetMapping("/subject-attendance/{id}")
    public Response<Object> show
    (
            @Token JWT jwt,
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok()
                           .setPayload(this.subjectAttendanceService.show(id));
        } catch (SubjectAttendanceNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    // @TODO - Make routes only available to other services, but not to api gateway
    @Authorized("STUDENT")
    @GetMapping("/private/subject-attendance/student/{id}")
    public List<SubjectAttendanceWithSubjectDTO> indexByStudentId
    (
            @Token JWT jwt,
            @PathVariable("id") Long id
    )
    {
        return this.subjectAttendanceService.getAllByStudentId(id);
    }

    @Authorized("STUDENT")
    @GetMapping("/private/subject-attendance/student/{id}/passed")
    public List<SubjectAttendanceWithSubjectDTO> indexPassedByStudentId
            (
                    @Token JWT jwt,
                    @PathVariable("id") Long id
            )
    {
        return this.subjectAttendanceService.getAllPassedByStudentId(id);
    }

    @Authorized("STUDENT")
    @GetMapping("/private/subject-attendance/student/{id}/not-passed")
    public List<SubjectAttendanceWithSubjectDTO> indexCurrentByStudentId
            (
                    @Token JWT jwt,
                    @PathVariable("id") Long id
            )
    {
        return this.subjectAttendanceService.getAllCurrentByStudentId(id);
    }


    /*
    @Authorized("ADMIN")
    @PostMapping("")
    public Response<Object> store
            (
                    @Token JWT jwt,
                    @Valid @RequestBody Object storeRequest,
                    Errors errors
            )
    {
        return Response.ok()
                       .setPayload("Not implemented");
    }

    @Authorized()
    @PutMapping("/{id}")
    public Response<Object> update
            (
                    @Token JWT jwt,
                    @Valid @RequestBody Object updateRequest,
                    @PathVariable("id") Long id,
                    Errors errors
            )
    {
        return Response.ok()
                       .setPayload("Not implemented");
    }

    @Authorized()
    @DeleteMapping("/{id}")
    public Response<Object> delete
            (
                    @Token JWT jwt,
                    @PathVariable("id") Long id,
                    Errors errors
            )
    {
        return Response.ok()
                       .setPayload("Not implemented");
    }

    */
}
