package com.ula.student.api.v1.controller;

import com.ula.student.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;
import org.ula.core.api.response.ResponseResolver;

@RestController
@Validated
public class SubjectController
{

    @Autowired
    private SubjectService subjectService;

    @Authorized("STUDENT")
    @GetMapping("/subject")
    public Response<Object> index
    (
            @RequestParam(value = "fetch", required = false) String passed

    )
    {
        if(passed != null)
        {
            if(passed.equals("passed"))
            {
                return Response.ok().setPayload(this.subjectService.indexPassed());
            } else if(passed.equals("not-passed"))
            {
                return Response.ok().setPayload(this.subjectService.indexNotPassed());
            } else {
                return Response.exception().setErrors("Param: fetch can only be either 'passed' or 'not-passed'");
            }
        }
         else {
            return Response.ok().setPayload(this.subjectService.index());
        }
    }

    @Authorized("STUDENT")
    @GetMapping("/subject/{id}")
    public Response<Object> show
    (
            @PathVariable("id") Long id
    )
    {
        return ResponseResolver.resolve(this.subjectService.show(id));

    }


}
