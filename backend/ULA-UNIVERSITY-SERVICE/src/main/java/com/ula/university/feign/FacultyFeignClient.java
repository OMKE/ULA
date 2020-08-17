package com.ula.university.feign;

import com.ula.university.dto.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ula-faculty-service")
public interface FacultyFeignClient
{
    @GetMapping("")
    Response<Object> getFaculties();
}
