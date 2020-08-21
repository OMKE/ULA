package com.ula.university.domain.repository;

import com.ula.university.domain.model.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>
{
}
