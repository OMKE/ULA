package com.ula.teacher.feign.hystrix;

import com.ula.teacher.api.v1.request.StoreAndUpdateSubjectNotificationRequest;
import com.ula.teacher.api.v1.request.StoreTeachingTermRequest;
import com.ula.teacher.api.v1.request.UpdateSubjectSyllabusRequest;
import com.ula.teacher.dto.StudentDTO;
import com.ula.teacher.dto.SubjectNotificationDTO;
import com.ula.teacher.dto.SubjectWithRealizationIdDTO;
import com.ula.teacher.feign.FacultyServiceFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.ula.core.api.response.Response;

import java.util.List;

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
            public List<SubjectWithRealizationIdDTO> getSubjects(String token, Long teacherId)
            {
                LOGGER.error("Error occurred while fetching subjects from Faculty Service", cause);
                return null;
            }

            @Override
            public SubjectWithRealizationIdDTO getSubjectById(
                    String token, Long teacherId, Long subjectId
                                                             )
            {
                LOGGER.error("Error occurred while fetching SubjectWithRealizationId from Faculty Service", cause);
                return null;
            }

            @Override
            public List<StudentDTO> getStudents(String token, Long subjectId, Pageable pageable)
            {
                LOGGER.error("Error occurred while fetching Students from Faculty Service", cause);
                return null;
            }

            @Override
            public List<SubjectNotificationDTO> getNotifications(
                    String token, Long teacherId, Pageable pageable
                                                                )
            {
                LOGGER.error("Error occurred while fetching Notifications from Faculty Service", cause);
                return null;
            }

            @Override
            public List<SubjectNotificationDTO> getNotificationsBySubject(
                    String token, Long subjectId, Pageable pageable
                                                                         )
            {
                LOGGER.error("Error occurred while fetching Notifications by Subject Id from Faculty Service", cause);
                return null;
            }

            @Override
            public Response<Object> addNotification(
                    String token, StoreAndUpdateSubjectNotificationRequest request
                                                   )
            {
                LOGGER.error("Error occurred while storing Notification to Faculty Service", cause);
                return null;
            }

            @Override
            public Response<Object> deleteNotification(String token, Long teacherId, Long notificationId)
            {
                LOGGER.error("Error occurred while deleting Notification from Faculty Service", cause);
                return null;
            }

            @Override
            public Response<Object> getTeachingTermsBySubjectId(String token, Long subjectId)
            {
                LOGGER.error("Error occurred while fetching Teaching terms based on subject from Faculty Service", cause);
                return null;
            }

            @Override
            public Response<Object> addTeachingTerm(
                    String token, Long teacherId, StoreTeachingTermRequest request
                                                   )
            {
                LOGGER.error("Error occurred while storing TeachingTerm to Faculty Service", cause);
                return null;
            }

            @Override
            public Response<Object> updateSubjectSyllabus(
                    String token, Long teacherId, Long subjectId, UpdateSubjectSyllabusRequest request
                                                         )
            {
                LOGGER.error("Error occurred while updating SubjectSyllabus in Faculty Service", cause);
                return null;
            }

            @Override
            public List<Long> getSubjectAttendancesBySubjectId(String token, Long teacherId, Long subjectId)
            {
                LOGGER.error("Error occurred while fetching SubjectAttendance IDs from Faculty Service", cause);
                return null;
            }
        };
    }
}
