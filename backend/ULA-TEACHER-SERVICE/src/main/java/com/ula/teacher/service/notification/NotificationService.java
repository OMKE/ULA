package com.ula.teacher.service.notification;

import com.ula.teacher.api.v1.request.StoreAndUpdateSubjectNotificationRequest;
import com.ula.teacher.dto.SubjectNotificationDTO;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import org.springframework.data.domain.Pageable;
import org.ula.core.api.response.Response;

import java.util.List;

public interface NotificationService
{
    List<SubjectNotificationDTO> index(Pageable pageable)
    throws TeacherNotFoundException;

    List<SubjectNotificationDTO> showBySubjectId(Long subjectId, Pageable pageable);

    Response<Object> store(StoreAndUpdateSubjectNotificationRequest request);

    Response<Object> delete(Long id)
    throws TeacherNotFoundException;
}
