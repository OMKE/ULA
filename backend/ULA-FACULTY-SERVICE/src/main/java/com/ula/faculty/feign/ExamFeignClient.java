package com.ula.faculty.feign;

import com.ula.faculty.dto.model.exam.ExamTermDTO;
import com.ula.faculty.dto.request.StoreTakingExamRequest;
import com.ula.faculty.feign.hystrix.ExamServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.ula.core.api.response.Response;

import java.util.List;

@FeignClient(value = "ula-exam-service", fallbackFactory = ExamServiceFallbackFactory.class)
public interface ExamFeignClient
{

    @PostMapping("/taking-exam")
    Response<Object> storeTakingExam(@RequestBody StoreTakingExamRequest request, @RequestHeader("Authorization") String token);

    @PostMapping("/private/taking-exam")
    Response<Object> storeManyTakingExam
            (
                    @RequestHeader("Authorization") String token,
                    @RequestBody List<StoreTakingExamRequest> requests
            );

    @GetMapping("/term/closest/{date}")
    ExamTermDTO getExamTerm(@PathVariable("date") String date);
}
