package com.ula.exam.feign.hystrix;

import com.ula.exam.dto.model.SubjectAttendanceDTO;
import com.ula.exam.feign.FacultyFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.ula.core.api.response.Response;

@Component
public class FacultyServiceFallbackFactory implements FallbackFactory<FacultyFeignClient>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(FacultyServiceFallbackFactory.class);

    @Override
    public FacultyFeignClient create(Throwable cause)
    {
        return new FacultyFeignClient()
        {
            @Override
            public Response<Object> getSubjectAttendanceById(Long id, String token)
            {
                LOGGER.error("Error has occurred while fetching subject attendance", cause);
                return Response.exception().setErrors("Error has occurred while fetching subject attendance");
            }

            @Override
            public SubjectAttendanceDTO getByStudentIdAndSubjectAttendanceId(
                    String token, Long studentId, Long resourceId
                                                                            )
            {
                LOGGER.error("Error has occurred while fetching subject attendance by student id and id", cause);
                return null;
            }
        };
    }
}
