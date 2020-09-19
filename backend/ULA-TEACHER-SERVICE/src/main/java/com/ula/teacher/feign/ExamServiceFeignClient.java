package com.ula.teacher.feign;

import com.ula.teacher.dto.TakingExamDTO;
import com.ula.teacher.api.v1.request.StoreExamsRequest;
import com.ula.teacher.api.v1.request.UpdateExamRequest;
import com.ula.teacher.api.v1.request.UpdateTakingExamRequest;
import com.ula.teacher.feign.hystrix.ExamServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.ula.core.api.response.Response;

@FeignClient(value = "ula-exam-service", fallbackFactory = ExamServiceFallbackFactory.class)
public interface ExamServiceFeignClient
{
    @PostMapping("/private/create-exam")
    Response<Object> createExam
            (
                @RequestHeader("Authorization") String token,
                StoreExamsRequest request
            );

    @GetMapping("/private/teacher/taking-exam/subject-attendance/{subjectAttendanceId}")
    TakingExamDTO getTakingExamBySubjectAttendanceId
            (
                    @RequestHeader("Authorization") String token,
                    @PathVariable("subjectAttendanceId") Long subjectAttendanceId
            );

    @GetMapping("/taking-exam/{id}/points")
    Response<Object> getTakingExamPointsCalculated
    (
            @RequestHeader("Authorization") String token,
            @PathVariable("id") Long takingExamId
    );

    // Get exam
    @GetMapping("/exam/{id}")
    Response<Object> getExam
    (
            @RequestHeader("Authorization") String token,
            @PathVariable("id") Long examId
    );

    // Update exam
    @PutMapping("/exam/{id}")
    Response<Object> updateExam
    (
            @RequestHeader("Authorization") String token,
            @PathVariable("id") Long examId,
            @RequestBody UpdateExamRequest request
    );

    // Update Taking Exam
    @PutMapping("/taking-exam/{id}")
    Response<Object> updateTakingExam
    (
            @RequestHeader("Authorization") String token,
            @PathVariable("id") Long takingExamId,
            @RequestBody UpdateTakingExamRequest request
    );

}
