package org.ula.core.feign.hystrix;


import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import org.ula.core.domain.model.ULAUserDTO;
import org.ula.core.feign.AuthServiceFeignClient;

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
