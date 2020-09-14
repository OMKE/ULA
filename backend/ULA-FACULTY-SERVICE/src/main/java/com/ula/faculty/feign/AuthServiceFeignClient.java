package com.ula.faculty.feign;

import com.ula.faculty.domain.model.TeacherDTO;
import com.ula.faculty.feign.hystrix.AuthServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "ula-auth-service", fallbackFactory = AuthServiceFallbackFactory.class)
public interface AuthServiceFeignClient
{
    // Returns currently logged teacher
    @GetMapping("/private/teacher")
    TeacherDTO getTeacher(@RequestHeader(value = "Authorization", required = true) String token);
}
