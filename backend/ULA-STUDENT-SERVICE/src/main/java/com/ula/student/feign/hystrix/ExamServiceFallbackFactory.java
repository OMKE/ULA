package com.ula.student.feign.hystrix;

import com.ula.student.api.v1.request.UpdateExamEntryRequest;
import com.ula.student.dto.ExamDTO;
import com.ula.student.dto.TakingExamDTO;
import com.ula.student.feign.ExamServiceFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExamServiceFallbackFactory implements FallbackFactory<ExamServiceFeignClient>
{

    private static Logger LOGGER = LoggerFactory.getLogger(ExamServiceFallbackFactory.class);

    @Override
    public ExamServiceFeignClient create(Throwable cause)
    {
        return new ExamServiceFeignClient()
        {
            @Override
            public TakingExamDTO getTakingExamBySubjectAttendanceId(
                    String token, Long studentId, Long subjectAttendanceId
                                                                   )
            {
                LOGGER.error("Error occurred while getting TakingExam by SubjectAttendanceId", cause);
                return null;
            }

            @Override
            public ExamDTO getExamByStudentIdAndSubjectAttendanceIdAndExamId(
                    String token, Long studentId, Long subjectAttendanceId, Long examId
                                                                            )
            {
                LOGGER.error("Error occurred while getting exam by StudentIdAndSubjectAttendanceId and ExamId", cause);
                return null;
            }

            @Override
            public String addExamEntry(
                    String token, Long studentId, Long subjectAttendanceId, Long examId,
                    UpdateExamEntryRequest updateExamEntryRequest
                                      )
            {
                LOGGER.error("Error occurred while placing exam entry", cause);
                return null;
            }
        };
    }
}
