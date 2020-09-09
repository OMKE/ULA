package com.ula.student.api.v1.controller;

import com.ula.student.service.exam.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;
import org.ula.core.annotation.Token;
import org.ula.core.api.response.Response;
import org.ula.core.api.response.ResponseResolver;
import org.ula.core.util.JWT;

@RestController
@Validated
public class ExamController
{

    @Autowired
    private ExamService examService;

    @Authorized("STUDENT")
    @GetMapping("/subject/{subjectAttendance}/exam/{examId}")
    public Response<Object> show
    (
            @Token JWT jwt,
            @PathVariable("subjectAttendance") Long subjectAttendanceId,
            @PathVariable("examId") Long examId
    )
    {
        return ResponseResolver.resolve(this.examService.show(subjectAttendanceId, examId));
    }
}
