package com.ula.student.api.v1.controller;

import com.ula.student.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;
import org.ula.core.annotation.Token;
import org.ula.core.api.response.Response;
import org.ula.core.util.JWT;

@RestController
@Validated
public class SubjectController
{

    @Autowired
    private SubjectService subjectService;

    @Authorized("STUDENT")
    @GetMapping("/subjects")
    public Response<Object> subjects
    (
            @Token JWT jwt
    )
    {
        return Response.ok().setPayload(this.subjectService.index());
    }

    @Authorized("STUDENT")
    @GetMapping("/subjects/passed")
    public Response<Object> subjectsPassed
    (
            @Token JWT jwt
    )
    {
        return Response.ok().setPayload(this.subjectService.indexPassed());
    }

    @Authorized("STUDENT")
    @GetMapping("/subjects/not-passed")
    public Response<Object> subjectsNotPassed
    (
            @Token JWT jwt
    )
    {
        return Response.ok().setPayload(this.subjectService.indexNotPassed());
    }
}
