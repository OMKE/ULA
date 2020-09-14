package com.ula.faculty.feign.hystrix;

import com.ula.faculty.domain.model.TeacherDTO;
import com.ula.faculty.feign.AuthServiceFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("AuthServiceFacultyServiceFallbackFactory")
public class AuthServiceFallbackFactory implements FallbackFactory<AuthServiceFeignClient>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceFallbackFactory.class);

    @Override
    public AuthServiceFeignClient create(Throwable cause)
    {
        return new AuthServiceFeignClient()
        {
            @Override
            public TeacherDTO getTeacher(String token)
            {
                LOGGER.error("Error occurred while fetching Teacher from Auth service", cause);
                return null;
            }
        };
    }
}
