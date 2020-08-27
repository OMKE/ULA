package com.ula.authentication.feign.hystrix;

import com.ula.authentication.feign.StaticContentServiceFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.ula.core.api.response.Response;

@Component
public class StaticContentServiceFallbackFactory implements FallbackFactory<StaticContentServiceFeignClient>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(StaticContentServiceFallbackFactory.class);

    @Override
    public StaticContentServiceFeignClient create(Throwable cause)
    {
        return new StaticContentServiceFeignClient()
        {
            @Override
            public Response<Object> addProfileImage(String token, MultipartFile file)
            {
                return Response.exception().setErrors("Error has occurred while storing profile image");
            }

            @Override
            public Response<Object> deleteProfileImage(String token, String username, Response response)
            {
                return Response.exception().setErrors("Error has occurred while deleting profile image");
            }
        };
    }
}
