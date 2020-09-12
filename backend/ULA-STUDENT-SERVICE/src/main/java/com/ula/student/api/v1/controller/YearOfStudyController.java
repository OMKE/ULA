package com.ula.student.api.v1.controller;

import com.ula.student.service.exception.YearOfStudyNotFoundException;
import com.ula.student.service.yearofstudy.YearOfStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;

@RestController
public class YearOfStudyController
{

    @Autowired
    private YearOfStudyService yearOfStudyService;


    @Authorized("STUDENT")
    @GetMapping("/year-of-study")
    public Response<Object> index()
    {
        return Response.ok().setPayload(this.yearOfStudyService.index());
    }

    @Authorized("STUDENT")
    @GetMapping("/year-of-study/{id}")
    public Response<Object> show
    (
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok().setPayload(this.yearOfStudyService.show(id));
        } catch (YearOfStudyNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
