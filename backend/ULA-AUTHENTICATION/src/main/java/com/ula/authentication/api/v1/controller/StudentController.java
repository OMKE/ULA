package com.ula.authentication.api.v1.controller;

import com.ula.authentication.api.v1.request.StoreStudentRequest;
import com.ula.authentication.api.v1.request.UpdateStudentRequest;
import com.ula.authentication.domain.guard.StudentGuard;
import com.ula.authentication.dto.model.StudentDTO;
import com.ula.authentication.service.exception.*;
import com.ula.authentication.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;

import javax.validation.Valid;


@RestController
@Validated
public class StudentController extends BaseController
{
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentGuard studentGuard;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/student")
    public Response<Object> index()
    {
        return Response.ok()
                       .setPayload(this.studentService.index());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/student/{id}")
    public Response<Object> show(@PathVariable("id") Long id)
    {
        try {
            return Response.ok()
                           .setPayload(this.studentService.show(id));
        } catch (StudentNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/student")
    public Response<Object> store
    (
            @Valid @RequestBody StoreStudentRequest storeRequest,
            Errors errors
    )
    {
        StudentDTO studentDTO = new StudentDTO()
                    .setPhoneNumber(this.sanitize(storeRequest.getPhoneNumber()))
                    .setDateOfBirth(storeRequest.getDateOfBirth())
                    .setSsn(this.sanitize(storeRequest.getSsn()));
        try {
            return Response.ok()
                           .setPayload(this.studentService.store(storeRequest.getUserId(), studentDTO));
        } catch (UserNotFoundException | UserIsAlreadyStudent | StudentSSNConflictException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/student/{id}")
    public Response<Object> update
    (
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateStudentRequest updateRequest,
            Errors errors

    )
    {
        StudentDTO studentDTO = new StudentDTO()
                    .setSsn(updateRequest.getSsn())
                    .setDateOfBirth(updateRequest.getDateOfBirth())
                    .setPhoneNumber(updateRequest.getPhoneNumber());

        try {
            return Response.ok()
                           .setPayload(this.studentService.update(id, studentDTO));
        } catch (StudentNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/student/{id}")
    public Response<Object> delete
    (
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok()
                           .setPayload(this.studentService.delete(id));
        } catch (StudentNotFoundException | UserNotFoundException | UserPermissionException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/student/{id}/restore")
    public Response<Object> restore
    (
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok()
                           .setPayload(this.studentService.restore(id));
        } catch (StudentNotFoundException | UserNotFoundException | UserPermissionException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('STUDENT') && @studentGuard.check(#username, authentication)")
    @GetMapping("/student/username/{username}")
    public StudentDTO getByUsername
    (
            @PathVariable("username") String username
    )
    {
        try {
            return this.studentService.getStudentBasedOnUsername(username);
        } catch (UserNotFoundException | StudentNotFoundException e) {
            return null;
        }
    }
}
