package com.ula.university.core.feign.hystrix;

import com.ula.university.core.feign.AuthServiceFeignClient;
import com.ula.university.core.util.ULAUserDTO;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceFallbackFactory implements FallbackFactory<AuthServiceFeignClient>
{
    @Override
    public AuthServiceFeignClient create(Throwable throwable)
    {
        return new AuthServiceFeignClient()
        {
            @Override
            public ULAUserDTO getUser(String token, String authorizeRoles)
            {
                return null;
            }
        };
    }
}
