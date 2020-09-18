package com.ula.teacher.api.v1.controller;

import com.ula.teacher.service.exception.SubjectWithRealizationIdNotFoundException;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import com.ula.teacher.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;

@RestController
public class SubjectController
{

    @Autowired
    private SubjectService subjectService;

    @Authorized("TEACHER")
    @GetMapping("/subject")
    public Response<Object> index()
    {
        return Response.ok().setPayload(this.subjectService.index());
    }

    @Authorized("TEACHER")
    @GetMapping("/subject/{id}")
    public Response<Object> show
            (
                    @PathVariable("id") Long subjectId
            )
    {
        try {
            return Response.ok().setPayload(this.subjectService.show(subjectId));
        } catch (SubjectWithRealizationIdNotFoundException | TeacherNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
