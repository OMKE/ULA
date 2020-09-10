package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.SubjectNotification;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface SubjectNotificationRepository extends CrudRepository<SubjectNotification, Long>
{
}
