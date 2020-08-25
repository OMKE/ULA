package com.ula.university.feign;


import com.ula.university.feign.hystrix.FacultyServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.ula.core.api.response.Response;


@FeignClient(name = "ula-faculty-service", fallbackFactory = FacultyServiceFallbackFactory.class)
public interface FacultyFeignClient
{
    @GetMapping("")
    Response<Object> getFaculties();
}
