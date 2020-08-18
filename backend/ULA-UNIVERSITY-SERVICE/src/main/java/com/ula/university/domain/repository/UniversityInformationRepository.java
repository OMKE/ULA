package com.ula.university.domain.repository;

import com.ula.university.domain.model.UniversityInformation;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversityInformationRepository extends CrudRepository<UniversityInformation, Long>
{

    Optional<UniversityInformation> findByUniversityId(Long id);
}
