package com.ula.authentication.service.user;

import com.ula.authentication.domain.model.User;
import com.ula.authentication.dto.model.UserDTO;
import com.ula.authentication.service.exception.PasswordsDontMatchException;
import com.ula.authentication.service.exception.UserConflictException;
import com.ula.authentication.service.exception.UserException;
import com.ula.authentication.service.exception.UserNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public interface UserService {

	Optional<User> getById(Long id) throws UserException, UserNotFoundException;

	Optional<User> getByIdTrashed(Long id) throws UserException;

	List<User> getAll();

	List<User> getAllWithTrashed();

	Optional<User> getByUsername(String username) throws UsernameNotFoundException, UserNotFoundException;

	Optional<User> getByUsernameAndPassword(String username, String password) throws UserNotFoundException;

	Optional<User> getByEmail(String email) throws UserException, UserNotFoundException;

	Optional<User> getByEmailAndPassword(String email, String password) throws UserNotFoundException;

	String add(UserDTO userDTO) throws UserException, UserConflictException;

	String updatePassword(UserDTO userDTO) throws UserException;

	HashMap<String, String> login(UserDTO userDTO) throws UserException, UsernameNotFoundException;

	String delete(Long id) throws UserException, UserNotFoundException;

	String restore(Long id) throws UserException;

	UserDTO getUserData(String username) throws UserException, UserNotFoundException;

	void verifyEmail(User user);

	void checkForPasswords(String password, String confirmPassword)
			throws PasswordsDontMatchException;

	void checkTermsAndConditions(String value) throws UserException;

	/*
	 * @TODO - force delete
	 */

}
