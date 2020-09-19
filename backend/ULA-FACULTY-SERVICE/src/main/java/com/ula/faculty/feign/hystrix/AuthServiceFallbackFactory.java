package com.ula.faculty.feign.hystrix;

import com.ula.faculty.domain.model.TeacherDTO;
import com.ula.faculty.dto.model.StudentDTO;
import com.ula.faculty.feign.AuthServiceFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

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

            @Override
            public StudentDTO getStudent(String token, String username)
            {
                LOGGER.error("Error occurred while fetching Student by username from Auth service", cause);
                return null;
            }

            @Override
            public StudentDTO getStudentById(String token, Long studentId)
            {
                LOGGER.error("Error occurred while fetching Student by id from Auth service", cause);
                return null;
            }

            @Override
            public List<StudentDTO> getAllStudents(String token, List<Long> ids)
            {
                LOGGER.error("Error occurred while fetching students with list of ids from Auth service", cause);
                return null;
            }

            @Override
            public List<StudentDTO> searchStudents(String token, String searchParam)
            {
                LOGGER.error("Error occurred while searching students from Auth service", cause);
                return null;
            }
        };
    }
}
