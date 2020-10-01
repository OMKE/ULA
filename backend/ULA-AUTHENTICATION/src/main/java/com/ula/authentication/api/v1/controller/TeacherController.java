package com.ula.authentication.api.v1.controller;

import com.ula.authentication.api.v1.request.StoreTeacherRequest;
import com.ula.authentication.api.v1.request.UpdateTeacherRequest;
import com.ula.authentication.dto.model.TeacherDTO;
import com.ula.authentication.service.exception.TeacherNotFoundException;
import com.ula.authentication.service.exception.UserIsAlreadyTeacherException;
import com.ula.authentication.service.exception.UserNotFoundException;
import com.ula.authentication.service.exception.UserPermissionException;
import com.ula.authentication.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;

import javax.validation.Valid;

@RestController
@Validated
public class TeacherController extends BaseController
{
    @Autowired
    private TeacherService teacherService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/teacher")
    public Response<Object> index()
    {
        return Response.ok().setPayload(this.teacherService.index());
    }



    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/private/teacher")
    public TeacherDTO getLoggedInTeacher(Authentication authentication)
    {
        try {
            return this.teacherService.getByUsername(authentication.getName());
        } catch (UserNotFoundException | TeacherNotFoundException e) {
            return null;
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/teacher/{id}")
    public Response<Object> show(@PathVariable("id") Long id)
    {
        try {
            return Response.ok().setPayload(this.teacherService.show(id));
        } catch (TeacherNotFoundException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/teacher")
    public Response<Object> store
    (
            @Valid @RequestBody StoreTeacherRequest storeRequest,
            Errors errors
    )
    {
        TeacherDTO teacherDTO = new TeacherDTO()
                    .setBiography(this.sanitize(storeRequest.getBiography()));


        try {
            return Response.ok().setPayload(this.teacherService.store(storeRequest.getUserId(), teacherDTO));
        } catch (UserNotFoundException | UserIsAlreadyTeacherException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/teacher/{id}")
    public Response<Object> update
    (
                    @Valid @RequestBody UpdateTeacherRequest updateTeacherRequest,
                    @PathVariable("id") Long id,
                    Errors errors
    )
    {
        TeacherDTO teacherDTO = new TeacherDTO()
                    .setBiography(this.sanitize(updateTeacherRequest.getBiography()));

        try {
            return Response.ok().setPayload(this.teacherService.update(id, teacherDTO));
        } catch (TeacherNotFoundException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/teacher/{id}")
    public Response<Object> delete
    (
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok().setPayload(this.teacherService.delete(id));
        } catch (TeacherNotFoundException | UserNotFoundException | UserPermissionException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/teacher/{id}/restore")
    public Response<Object> restore
    (
            @PathVariable("id") Long id
    )
    {

        try {
            return Response.ok().setPayload(this.teacherService.restore(id));
        } catch (TeacherNotFoundException | UserNotFoundException | UserPermissionException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }

    }
}
