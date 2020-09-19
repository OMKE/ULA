package com.ula.teacher.feign.hystrix;

import com.ula.teacher.dto.TakingExamDTO;
import com.ula.teacher.api.v1.request.StoreExamsRequest;
import com.ula.teacher.api.v1.request.UpdateExamRequest;
import com.ula.teacher.api.v1.request.UpdateTakingExamRequest;
import com.ula.teacher.feign.ExamServiceFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.ula.core.api.response.Response;

@Component
public class ExamServiceFallbackFactory implements FallbackFactory<ExamServiceFeignClient>
{

    private static final Logger LOGGER = LoggerFactory.getLogger(ExamServiceFallbackFactory.class);

    @Override
    public ExamServiceFeignClient create(Throwable cause)
    {
        return new ExamServiceFeignClient()
        {
            @Override
            public Response<Object> createExam(
                    String token, StoreExamsRequest request
                                              )
            {
                LOGGER.error("Error occurred while creating requests in Exam service", cause);
                return Response.exception().setErrors(cause.getMessage());
            }

            @Override
            public TakingExamDTO getTakingExamBySubjectAttendanceId(
                    String token, Long subjectAttendanceId
                                                                   )
            {
                LOGGER.error("Error occurred while fetching Taking Exam from Exam service");
                return null;
            }

            @Override
            public Response<Object> getTakingExamPointsCalculated(String token, Long takingExamId)
            {
                LOGGER.error("Error occurred while fetching Taking Exam Points from Exam service");
                return null;
            }

            @Override
            public Response<Object> getExam(String token, Long examId)
            {
                LOGGER.error("Error occurred while fetching Exam from Exam service");
                return null;
            }

            @Override
            public Response<Object> updateExam(String token, Long examId, UpdateExamRequest request)
            {
                LOGGER.error("Error occurred while updating Exam in Exam service", cause);
                return null;
            }

            @Override
            public Response<Object> updateTakingExam(
                    String token, Long takingExamId, UpdateTakingExamRequest request
                                                    )
            {
                LOGGER.error("Error occurred while updating Taking Exam in Exam service", cause);
                return null;
            }
        };
    }
}
