package com.ula.faculty.api.v1.controller;

import com.ula.faculty.api.v1.request.StoreTeachingMaterialAuthorRequest;
import com.ula.faculty.api.v1.request.StoreTeachingTermRequest;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.SubjectRealizationNotFoundException;
import com.ula.faculty.service.exception.TeacherOnRealizationNotFoundException;
import com.ula.faculty.service.exception.TeachingTypeNotFoundException;
import com.ula.faculty.service.teachingterm.TeachingTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;
import org.ula.core.exception.NotAuthorizedException;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@Validated
public class TeachingTermController extends BaseController
{
    @Autowired
    private TeachingTermService teachingTermService;


    @Authorized("[ADMIN, TEACHER]")
    @GetMapping("/subject/{id}/term")
    public Response<Object> index(@PathVariable("id") Long subjectId)
    {
        try {
            return Response.ok().setPayload(this.teachingTermService.index(subjectId));
        } catch (SubjectRealizationNotFoundException | SubjectNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("TEACHER")
    @PostMapping("/teacher/{teacherId}/teaching-term")
    public Response<Object> store
    (
            @PathVariable("teacherId") Long teacherId,
            @Valid @RequestBody StoreTeachingTermRequest request,
            Errors errors
    )
    {
        request.setTeachingMaterialName(this.sanitize(request.getTeachingMaterialName()))
               .setTeachingTermOutcomeDescription(this.sanitize(request.getTeachingTermOutcomeDescription()))
               .setAuthors(
                       request
                           .getAuthors()
                           .stream()
                           .map(author ->
                                 new StoreTeachingMaterialAuthorRequest()
                                         .setFirstName(this.sanitize(author.getFirstName()))
                                    .setLastName(this.sanitize(author.getLastName()))
                               ).collect(Collectors.toList())
                          );
        try {
            return Response.ok().setPayload(this.teachingTermService.store(teacherId, request));
        } catch (SubjectRealizationNotFoundException | NotAuthorizedException | TeachingTypeNotFoundException | TeacherOnRealizationNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

}
