package com.ula.teacher.feign;

import com.ula.teacher.dto.request.CreateExamsRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.ula.core.api.response.Response;

@FeignClient("ula-exam-service")
public interface ExamServiceFeignClient
{
    @PostMapping("/private/create-exam")
    Response<Object> createExam
            (
                @RequestHeader("Authorization") String token,
                CreateExamsRequest request
            );
}
