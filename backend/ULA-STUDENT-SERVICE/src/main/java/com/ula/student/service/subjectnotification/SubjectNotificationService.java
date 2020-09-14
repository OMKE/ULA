package com.ula.student.service.subjectnotification;

import com.ula.student.dto.SubjectNotificationDTO;
import com.ula.student.service.exception.SubjectAttendanceWithSubjectDTONotFoundException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubjectNotificationService
{
    List<SubjectNotificationDTO> index(Pageable pageable);

    List<SubjectNotificationDTO> indexBySubjectId(Long subjectId, Pageable pageable)
    throws SubjectAttendanceWithSubjectDTONotFoundException;
}
