package com.ula.university.feign.hystrix;


import com.ula.university.feign.FacultyFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.ula.core.api.response.Response;

import java.util.Collections;

@Component
public class FacultyServiceFallbackFactory implements FallbackFactory<FacultyFeignClient>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(FacultyServiceFallbackFactory.class);

    @Override
    public FacultyFeignClient create(Throwable throwable)
    {
        return new FacultyFeignClient()
        {
            @Override
            public Response<Object> getFaculties()
            {
                LOGGER.error("Error has occurred while fetching faculties from faculty service", throwable);
                return Response.exception().setErrors("Error has occurred while fetching faculties from faculty service").setPayload(Collections.emptyList());
            }
        };
    }
}
