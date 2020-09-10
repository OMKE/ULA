package com.ula.student.feign;

import com.ula.student.api.v1.request.UpdateExamEntryRequest;
import com.ula.student.dto.ExamDTO;
import com.ula.student.dto.TakingExamDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "ula-exam-service")
public interface ExamServiceFeignClient
{
    @GetMapping("/private/taking-exam/subject-attendance/{studentId}/{id}")
    TakingExamDTO getTakingExamBySubjectAttendanceId
            (
                    @RequestHeader("Authorization") String token,
                    @PathVariable("studentId") Long studentId,
                    @PathVariable("id") Long subjectAttendanceId

            );

    @GetMapping("/private/taking-exam/subject-attendance/{studentId}/{subjectAttendanceId}/{examId}")
    ExamDTO getExamByStudentIdAndSubjectAttendanceIdAndExamId
            (
                    @RequestHeader("Authorization") String token,
                    @PathVariable("studentId") Long studentId,
                    @PathVariable("subjectAttendanceId") Long subjectAttendanceId,
                    @PathVariable("examId") Long examId
            );

    @PostMapping("/private/taking-exam/subject-attendance/{studentId}/{subjectAttendanceId}/{examId}")
    String addExamEntry
            (
                    @RequestHeader("Authorization") String token,
                    @PathVariable("studentId") Long studentId,
                    @PathVariable("subjectAttendanceId") Long subjectAttendanceId,
                    @PathVariable("examId") Long examId,
                    @RequestBody UpdateExamEntryRequest updateExamEntryRequest
            );
}
