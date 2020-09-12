package com.ula.student.api.v1.controller;

import com.ula.student.service.takingexam.TakingExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;
import org.ula.core.api.response.ResponseResolver;

@RestController
@Validated
public class TakingExamController
{

    @Autowired
    private TakingExamService takingExamService;


    /*
        {id] - subjectAttendanceId
     */
    @Authorized("STUDENT")
    @GetMapping("/subject/{id}/exam")
    public Response<Object> show
    (
            @PathVariable("id") Long id
    )
    {
        return ResponseResolver.resolve(this.takingExamService.show(id));
    }



}
