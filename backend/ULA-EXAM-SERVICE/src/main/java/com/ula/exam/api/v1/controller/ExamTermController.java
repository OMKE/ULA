package com.ula.exam.api.v1.controller;

import com.ula.exam.service.examterm.ExamTermService;
import com.ula.exam.service.exception.ExamTermNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.api.response.Response;

@RestController
@Validated
public class ExamTermController 
{
    @Autowired
    private ExamTermService examTermService ;

    @GetMapping("/term")
    public Response<Object> index()
    {
        return Response.ok()
                       .setPayload(this.examTermService.index());
    }
    
    @GetMapping("/term/{id}")
    public Response<Object> show(@PathVariable("id") Long id)
    {
        try {
            return Response.ok()
                           .setPayload(this.examTermService.show(id));
        } catch (ExamTermNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
    

}
