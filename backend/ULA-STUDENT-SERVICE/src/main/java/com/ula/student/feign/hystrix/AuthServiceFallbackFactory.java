package com.ula.student.feign.hystrix;

import com.ula.student.dto.StudentDTO;
import com.ula.student.feign.AuthService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("AuthServiceStudentServiceFallbackFactory")
public class AuthServiceFallbackFactory implements FallbackFactory<AuthService>
{

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceFallbackFactory.class);

    @Override
    public AuthService create(Throwable cause)
    {
        return new AuthService()
        {
            @Override
            public StudentDTO getStudent(String token, String username)
            {
                LOGGER.error("There was an issue getting Student from Auth Service", cause);
                return null;
            }
        };
    }
}
