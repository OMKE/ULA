package com.ula.authentication.domain.repository;

import com.ula.authentication.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
	Optional<User> findByUsername(String username);

	Optional<User> findByUsernameAndPassword(String username, String password);

	Optional<User> findByEmail(String email);

	Optional<User> findByEmailAndPassword(String email, String password);

}
