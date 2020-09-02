package com.ula.faculty.api.v1.controller;

import com.ula.faculty.api.v1.request.StoreStudentOnYearRequest;
import com.ula.faculty.api.v1.request.UpdateStudentOnYearRequest;
import com.ula.faculty.service.exception.*;
import com.ula.faculty.service.studentonyyear.StudentOnYearService;
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
public class StudentOnYearController extends BaseController
{
    @Autowired
    private StudentOnYearService studentOnYearService;

    @GetMapping("/student-on-year")
    public Response<Object> index()
    {
        return Response.ok()
                       .setPayload(this.studentOnYearService.index());
    }

    @GetMapping("/student-on-year/{id}")
    public Response<Object> show(@PathVariable("id") Long id)
    {
        try {
            return Response.ok()
                           .setPayload(this.studentOnYearService.show(id));
        } catch (StudentOnYearNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @PostMapping("/student-on-year")
    public Response<Object> store
            (
                    @Token JWT jwt,
                    @Valid @RequestBody StoreStudentOnYearRequest storeRequest,
                    Errors errors
            )
    {


        try {
            return Response.ok()
                           .setPayload(this.studentOnYearService.store(jwt.getContent(), storeRequest));
        } catch (StudentOnYearNotFoundException |
                YearOfStudyNotFoundException |
                StudentNotFoundException |
                StudentOnYearConflictException |
                SubjectRealizationNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @PutMapping("/student-on-year/{id}")
    public Response<Object> update
            (
                    @Token JWT jwt,
                    @Valid @RequestBody UpdateStudentOnYearRequest updateRequest,
                    @PathVariable("id") Long id,
                    Errors errors
            )
    {


        try {
            return Response.ok()
                           .setPayload(this.studentOnYearService.addYearOfStudy(id, updateRequest, jwt.getContent()));
        } catch (StudentNotFoundException |
                YearOfStudyNotFoundException |
                StudentOnYearConflictException |
                StudentOnYearNotFoundException |
                SubjectRealizationNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @DeleteMapping("/student-on-year/{id}")
    public Response<Object> delete
            (
                    @Token JWT jwt,
                    @PathVariable("id") Long id
            )
    {
        try {
            return Response.ok()
                           .setPayload(this.studentOnYearService.delete(id));
        } catch (StudentOnYearNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
