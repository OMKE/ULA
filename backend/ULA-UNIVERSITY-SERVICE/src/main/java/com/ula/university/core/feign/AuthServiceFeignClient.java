package com.ula.university.core.feign;

import com.ula.university.core.feign.hystrix.AuthServiceFallbackFactory;
import com.ula.university.core.util.ULAUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "ula-auth-service", fallbackFactory = AuthServiceFallbackFactory.class)
public interface AuthServiceFeignClient
{
    @PostMapping("user")
    ULAUserDTO getUser(@RequestHeader(value = "Authorization", required = true) String token, @RequestBody String authorizeRoles);
}
