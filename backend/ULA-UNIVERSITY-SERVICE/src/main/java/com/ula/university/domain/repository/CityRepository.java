package com.ula.university.domain.repository;

import com.ula.university.domain.model.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long>
{

//    @Query("SELECT c FROM City c WHERE c.deleted=false and c.name= :name")
//    Optional<City> findByName(@Param("name") String name);


}
