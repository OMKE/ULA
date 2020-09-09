package com.ula.student.api.v1.controller;

import com.ula.student.service.student.StudentService;
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
public class StudentController 
{
    @Autowired
    private StudentService studentService;

    @Authorized("STUDENT")
    @GetMapping("/me")
    public Response<Object> show
    (
            @Token JWT jwt
    )
    {
        return Response.ok()
                       .setPayload(this.studentService.getStudent(jwt.getUsername()));
    }

}
