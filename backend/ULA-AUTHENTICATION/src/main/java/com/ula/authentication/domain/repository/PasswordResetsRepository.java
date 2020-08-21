package com.ula.authentication.domain.repository;

import com.ula.authentication.domain.model.PasswordResets;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface PasswordResetsRepository extends CrudRepository<PasswordResets, Long>
{

	
	
	@Query("select e from #{#entityName} e where e.token=?1 and e.deleted=false")
	Optional<PasswordResets> findByToken(String token);
}
