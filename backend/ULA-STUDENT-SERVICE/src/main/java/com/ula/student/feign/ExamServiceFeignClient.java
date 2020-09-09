package com.ula.student.feign;

import com.ula.student.dto.ExamDTO;
import com.ula.student.dto.TakingExamDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

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
}