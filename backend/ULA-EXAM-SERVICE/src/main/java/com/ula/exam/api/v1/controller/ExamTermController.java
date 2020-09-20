package com.ula.exam.api.v1.controller;

import com.ula.exam.dto.model.ExamTermDTO;
import com.ula.exam.service.examterm.ExamTermService;
import com.ula.exam.service.exception.ExamTermNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.api.response.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


    @GetMapping("/term/closest/{date}")
    public ExamTermDTO showClosest
    (
            @PathVariable("date") String date
    )
    {
        try {
            Date parsed = new SimpleDateFormat("yyyy-MM-dd h:m").parse(date);
            return this.examTermService.showByClosestDate(parsed);
        } catch (ParseException e) {
            return null;
        }

    }
}
