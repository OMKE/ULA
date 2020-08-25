package org.ula.core.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.ula.core.domain.model.ULAUserDTO;
import org.ula.core.feign.hystrix.AuthServiceFallbackFactory;

@FeignClient(value = "ula-auth-service", fallbackFactory = AuthServiceFallbackFactory.class)
public interface AuthServiceFeignClient
{
    @PostMapping("user")
    ULAUserDTO getUser(@RequestHeader(value = "Authorization", required = true) String token, @RequestBody String authorizeRoles);
}
