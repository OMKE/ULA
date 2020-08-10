package com.ula.university.domain.repository;

import com.ula.university.domain.model.Campus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepository extends CrudRepository<Campus, Long>
{
}
