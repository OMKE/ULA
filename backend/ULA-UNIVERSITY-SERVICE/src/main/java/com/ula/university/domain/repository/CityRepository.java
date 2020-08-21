package com.ula.university.domain.repository;

import com.ula.university.domain.model.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long>
{
}
