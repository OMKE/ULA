package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.TeachingType;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface TeachingTypeRepository extends CrudRepository<TeachingType, Long>
{

}
