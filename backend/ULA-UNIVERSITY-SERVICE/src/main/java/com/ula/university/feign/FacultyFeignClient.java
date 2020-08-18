package com.ula.university.feign;

import com.ula.university.dto.response.Response;
import com.ula.university.feign.hystrix.FacultyServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "ula-faculty-service", fallbackFactory = FacultyServiceFallbackFactory.class)
public interface FacultyFeignClient
{
    @GetMapping("")
    Response<Object> getFaculties();
}
