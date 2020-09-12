package com.ula.faculty.api.v1.controller;

import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.TeachingMaterialNotFoundException;
import com.ula.faculty.service.teachingmaterial.TeachingMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.api.response.Response;

@RestController
@Validated
public class TeachingMaterialController
{
    @Autowired
    private TeachingMaterialService teachingMaterialService;

    @GetMapping("/subject/{id}/teaching-material")
    public Response<Object> index(@PathVariable("id") Long subjectId)
    {

        try {
            return Response.ok().setPayload(this.teachingMaterialService.index(subjectId));
        } catch (SubjectNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @GetMapping("/teaching-material/{id}")
    public Response<Object> show(@PathVariable("id") Long id)
    {
        try {
            return Response.ok().setPayload(this.teachingMaterialService.show(id));
        } catch (TeachingMaterialNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
