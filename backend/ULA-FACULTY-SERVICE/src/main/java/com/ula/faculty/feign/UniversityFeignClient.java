package com.ula.faculty.feign;


import com.ula.faculty.feign.hystrix.UniversityServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.ula.core.api.response.Response;

@FeignClient(value = "ula-university-service", fallbackFactory = UniversityServiceFallbackFactory.class)
public interface UniversityFeignClient
{
    @GetMapping("/contact/address/{id}")
    Response<Object> getAddress(@PathVariable("id") Long id);

    @GetMapping("/location/{id}")
    Response<Object> getLocation(@PathVariable("id") Long id);
}
