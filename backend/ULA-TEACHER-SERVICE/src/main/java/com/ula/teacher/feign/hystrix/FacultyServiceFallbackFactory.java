package com.ula.teacher.feign.hystrix;

import com.ula.teacher.dto.SubjectWithRealizationIdDTO;
import com.ula.teacher.feign.FacultyServiceFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FacultyServiceFallbackFactory implements FallbackFactory<FacultyServiceFeignClient>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(FacultyServiceFallbackFactory.class);

    @Override
    public FacultyServiceFeignClient create(Throwable cause)
    {
        return new FacultyServiceFeignClient()
        {
            @Override
            public SubjectWithRealizationIdDTO getSubjectById(
                    String token, Long teacherId, Long subjectId
                                                             )
            {
                LOGGER.error("Error occurred while fetching SubjectWithRealizationId from Faculty Service", cause);
                return null;
            }
        };
    }
}
