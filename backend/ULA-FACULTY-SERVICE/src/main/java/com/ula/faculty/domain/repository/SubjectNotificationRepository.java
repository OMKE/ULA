package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.SubjectNotification;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.List;

@Repository
public interface SubjectNotificationRepository extends CrudRepository<SubjectNotification, Long>
{
    List<SubjectNotification> findBySubjectRealizationIdOrderByCreatedAtDesc(Long subjectRealizationId, Pageable pageable);
    List<SubjectNotification> findAllBySubjectRealizationIdInOrderByCreatedAtDesc(List<Long> ids, Pageable pageable);
}
