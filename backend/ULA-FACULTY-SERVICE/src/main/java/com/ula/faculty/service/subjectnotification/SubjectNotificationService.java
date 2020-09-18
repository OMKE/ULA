package com.ula.faculty.service.subjectnotification;

import com.ula.faculty.api.v1.request.StoreAndUpdateSubjectNotificationRequest;
import com.ula.faculty.dto.model.SubjectNotificationDTO;
import com.ula.faculty.service.exception.*;
import org.springframework.data.domain.Pageable;
import org.ula.core.exception.NotAuthorizedException;

import java.util.List;

public interface SubjectNotificationService
{
    List<SubjectNotificationDTO> index(Long subjectId, Pageable pageable)
    throws SubjectRealizationNotFoundException;

    SubjectNotificationDTO show(Long id)
    throws SubjectNotificationNotFoundException;

    List<SubjectNotificationDTO> getByStudentId(Long studentId, Pageable pageable)
    throws StudentOnYearNotFoundException;

    List<SubjectNotificationDTO> getByTeacherId(Long teacherId, Pageable pageable)
    throws TeacherOnRealizationNotFoundException;

    String store(StoreAndUpdateSubjectNotificationRequest storeRequest)
    throws SubjectRealizationNotFoundException, TeacherOnRealizationNotFoundException, SubjectNotificationTypeNotFoundException, NotAuthorizedException;

    String update(Long id, StoreAndUpdateSubjectNotificationRequest updateRequest);

    String delete(Long id, Long teacherId)
    throws SubjectNotificationNotFoundException, NotAuthorizedException, TeacherOnRealizationNotFoundException;
}
