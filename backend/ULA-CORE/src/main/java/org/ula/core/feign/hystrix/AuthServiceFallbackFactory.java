package org.ula.core.feign.hystrix;


import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.ula.core.api.response.Response;
import org.ula.core.domain.model.ULAUserDTO;
import org.ula.core.feign.AuthServiceFeignClient;

@Component
public class AuthServiceFallbackFactory implements FallbackFactory<AuthServiceFeignClient>
{

    private static Logger LOGGER = LoggerFactory.getLogger(AuthServiceFallbackFactory.class);

    @Override
    public AuthServiceFeignClient create(Throwable throwable)
    {
        return new AuthServiceFeignClient()
        {
            @Override
            public ULAUserDTO getUser(String token, String authorizeRoles)
            {
                LOGGER.error("Error occurred while fetching user from auth service", throwable);
                return null;
            }

            @Override
            public Response<Object> getStudent(Long id, String token)
            {
                LOGGER.error("Error occurred while fetching student from auth service", throwable);
                return Response.exception().setErrors("Error occurred while fetching student from auth service");
            }
        };
    }
}
