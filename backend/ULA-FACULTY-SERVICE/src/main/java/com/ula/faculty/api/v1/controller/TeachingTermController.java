package com.ula.faculty.api.v1.controller;

import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.SubjectRealizationNotFoundException;
import com.ula.faculty.service.teachingterm.TeachingTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;

@RestController
@Validated
public class TeachingTermController
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
}
