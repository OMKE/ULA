package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.StudyProgramLocation;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface StudyProgramLocationRepository extends CrudRepository<StudyProgramLocation, Long>
{

}
