package com.ula.domain.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ula.domain.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
	Optional<User> findByUsername(String username);

	Optional<User> findByUsernameAndPassword(String username, String password);

	Optional<User> findByEmail(String email);

	Optional<User> findByEmailAndPassword(String email, String password);

}