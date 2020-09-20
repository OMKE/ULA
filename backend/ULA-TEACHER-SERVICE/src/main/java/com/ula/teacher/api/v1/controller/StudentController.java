package com.ula.teacher.api.v1.controller;

import com.ula.teacher.service.exception.StudentOnYearNotFoundException;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import com.ula.teacher.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;

import java.util.Optional;

@RestController
public class StudentController
{

    @Autowired
    private StudentService studentService;

    @Authorized("TEACHER")
    @GetMapping("/student")
    public Response<Object> index
    (
            @RequestParam(value = "search", required = false) Optional<String> searchParam,
            Pageable pageable
    )
    {
        if(searchParam.isPresent() && !searchParam.get().equals(""))
        {
            return Response.ok().setPayload(this.studentService.search(searchParam.get()));
        } else {
            try {
                return Response.ok().setPayload(this.studentService.index(pageable));
            } catch (TeacherNotFoundException e) {
                return Response.exception().setErrors(e.getMessage());
            }
        }
    }


    @Authorized("TEACHER")
    @GetMapping("/student/{studentId}")
    public Response<Object> show
    (
            @PathVariable("studentId") Long studentId
    )
    {
        try {
            return Response.ok().setPayload(this.studentService.show(studentId));
        } catch (StudentOnYearNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("TEACHER")
    @GetMapping("/subject/{subjectId}/student")
    public Response<Object> getStudentsBySubject
            (
                    @PathVariable("subjectId") Long subjectId,
                    Pageable pageable
            )
    {
        return Response.ok().setPayload(this.studentService.getStudentsBySubjectId(subjectId, pageable));
    }

    @Authorized("TEACHER")
    @GetMapping("/subject/{subjectId}/student/{studentId}")
    public Response<Object> getStudentOnSubject
    (
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("studentId") Long studentId
    )
    {
        try {
            return Response.ok().setPayload(this.studentService.showInSubject(subjectId, studentId));
        } catch (StudentOnYearNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

}
