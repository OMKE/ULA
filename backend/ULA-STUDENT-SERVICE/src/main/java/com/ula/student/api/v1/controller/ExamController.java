package com.ula.student.api.v1.controller;

import com.ula.student.api.v1.request.UpdateExamEntryRequest;
import com.ula.student.service.exam.ExamService;
import com.ula.student.service.exception.EntryIsAlreadyActiveException;
import com.ula.student.service.exception.ExamNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;
import org.ula.core.api.response.ResponseResolver;

import javax.validation.Valid;

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
            @PathVariable("subjectAttendance") Long subjectAttendanceId,
            @PathVariable("examId") Long examId
    )
    {
        return ResponseResolver.resolve(this.examService.show(subjectAttendanceId, examId));
    }

    @Authorized("STUDENT")
    @PostMapping("/subject/{subjectAttendance}/exam/{examId}")
    public Response<Object> addExamEntry
    (
            @PathVariable("subjectAttendance") Long subjectAttendanceId,
            @PathVariable("examId") Long examId,
            @Valid @RequestBody UpdateExamEntryRequest updateRequest

    )
    {
        try {
            return ResponseResolver.resolve(this.examService.storeEntry(subjectAttendanceId, examId, updateRequest));
        } catch (EntryIsAlreadyActiveException | ExamNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
