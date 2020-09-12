package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.TeachingMaterial;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface TeachingMaterialRepository extends CrudRepository<TeachingMaterial, Long>
{
    TeachingMaterial findByTeachingTermId(Long teachingTermId);
}
