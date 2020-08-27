package com.ula.authentication.domain.repository;

import com.ula.authentication.domain.model.Administrator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Long>
{
    @Query("select e from #{#entityName} e where e.deleted=false and e.id=?1")
    Optional<Administrator> findByUserId(Long userId);
}
