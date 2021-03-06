package com.ula.faculty.feign.hystrix;

import com.ula.faculty.dto.model.exam.ExamTermDTO;
import com.ula.faculty.dto.request.StoreTakingExamRequest;
import com.ula.faculty.feign.ExamFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.ula.core.api.response.Response;

import java.util.List;

@Component
public class ExamServiceFallbackFactory implements FallbackFactory<ExamFeignClient>
{
    private static Logger LOGGER = LoggerFactory.getLogger(ExamServiceFallbackFactory.class);

    @Override
    public ExamFeignClient create(Throwable cause)
    {
        return new ExamFeignClient()
        {
            @Override
            public Response<Object> storeTakingExam(
                    StoreTakingExamRequest request, String token
                                                   )
            {
                LOGGER.error("Error occurred while trying to store taking exam", cause);
                return Response.exception().setErrors(cause.getMessage());
            }

            @Override
            public Response<Object> storeManyTakingExam(
                    String token, List<StoreTakingExamRequest> requests
                                                       )
            {
                LOGGER.error("Error occurred while trying to store an array of taking exam", cause);
                return null;
            }

            @Override
            public ExamTermDTO getExamTerm(String date)
            {
                LOGGER.error("Error occurred while fetching Exam Term from Exam service", cause);
                return null;
            }
        };
    }
}
