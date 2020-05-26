package com.ula.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ula.domain.model.PasswordResets;

@Repository
public interface PasswordResetsRepository extends CrudRepository<PasswordResets, Long>
{

	
	
	@Query("select e from #{#entityName} e where e.token=?1 and e.deleted=false")
	Optional<PasswordResets> findByToken(String token);
}
