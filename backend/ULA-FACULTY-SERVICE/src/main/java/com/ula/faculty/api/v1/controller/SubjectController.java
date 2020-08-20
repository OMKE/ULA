package com.ula.faculty.api.v1.controller;

import com.ula.faculty.dto.response.Response;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController
{

    @Autowired
    private SubjectService subjectService;


    @GetMapping("/subjects/{id}")
    public Response<Object> show(@PathVariable("id") Long id)
    {
        try {
            return Response.ok().setPayload(this.subjectService.show(id));
        } catch (SubjectNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
