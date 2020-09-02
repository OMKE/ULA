package org.ula.core.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.ula.core.domain.model.ULAUserDTO;
import org.ula.core.feign.hystrix.AuthServiceFallbackFactory;
import org.ula.core.api.response.Response;


@FeignClient(value = "ula-auth-service", fallbackFactory = AuthServiceFallbackFactory.class)
public interface AuthServiceFeignClient
{
    @PostMapping("user")
    ULAUserDTO getUser(@RequestHeader(value = "Authorization", required = true) String token, @RequestBody String authorizeRoles);

    @GetMapping("/student/{id}")
    Response<Object> getStudent
            (
                    @PathVariable("id") Long id,
                    @RequestHeader(value = "Authorization") String token
            );
}
