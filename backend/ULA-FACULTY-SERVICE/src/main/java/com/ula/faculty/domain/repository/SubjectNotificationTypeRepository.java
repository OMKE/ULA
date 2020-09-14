package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.SubjectNotificationType;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface SubjectNotificationTypeRepository extends CrudRepository<SubjectNotificationType, Long>
{
}
