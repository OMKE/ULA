package com.ula.authentication.domain.repository;

import com.ula.authentication.domain.model.User;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.Optional;




@Repository
public interface UserRepository extends CrudRepository<User, Long>
{

	Optional<User> findByUsernameAndDeletedFalse(String username);

	Optional<User> findByUsernameAndPasswordAndDeletedFalse(String username, String password);

	Optional<User> findByEmail(String email);

	Optional<User> findByEmailAndPasswordAndDeletedFalse(String email, String password);

}
