package com.ula.student.feign;

import com.ula.student.dto.StudentDTO;
import com.ula.student.feign.hystrix.AuthServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "ula-auth-service", fallbackFactory = AuthServiceFallbackFactory.class)
public interface AuthService
{
    @GetMapping("/student/username/{username}")
    StudentDTO getStudent(@RequestHeader("Authorization") String token, @PathVariable("username") String username);
}
