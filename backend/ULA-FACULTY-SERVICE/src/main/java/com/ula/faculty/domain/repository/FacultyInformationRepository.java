package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.FacultyInformation;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface FacultyInformationRepository extends CrudRepository<FacultyInformation, Long> { }
