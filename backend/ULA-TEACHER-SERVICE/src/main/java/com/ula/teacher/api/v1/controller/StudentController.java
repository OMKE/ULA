package com.ula.teacher.api.v1.controller;

import com.ula.teacher.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;

@RestController
public class StudentController
{

    @Autowired
    private StudentService studentService;


    @Authorized("TEACHER")
    @GetMapping("/subject/{subjectId}/student")
    public Response<Object> index
    (
            @PathVariable("subjectId") Long subjectId,
            Pageable pageable
    )
    {
        return Response.ok().setPayload(this.studentService.getStudentsBySubjectId(subjectId, pageable));
    }

}
