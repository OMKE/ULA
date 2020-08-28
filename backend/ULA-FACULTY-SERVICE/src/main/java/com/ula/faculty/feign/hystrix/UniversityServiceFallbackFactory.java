package com.ula.faculty.feign.hystrix;

import com.ula.faculty.feign.UniversityFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.ula.core.api.response.Response;

@Component
public class UniversityServiceFallbackFactory implements FallbackFactory<UniversityFeignClient>
{
    @Override
    public UniversityFeignClient create(Throwable cause)
    {
        return new UniversityFeignClient()
        {
            @Override
            public Response<Object> getAddress(Long id)
            {
                return Response.ok().setPayload(null);
            }

            @Override
            public Response<Object> getLocation(Long id)
            {
                return Response.ok().setPayload(null);
            }
        };
    }
}
