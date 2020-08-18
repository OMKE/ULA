package com.ula.university.domain.repository;

import com.ula.university.domain.model.PhoneNumber;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Long>
{
    List<PhoneNumber> findByUniversityId(Long id);
}
