package com.ula.authentication.service.user;

import com.ula.authentication.domain.model.User;
import com.ula.authentication.dto.model.UserDTO;
import com.ula.authentication.service.exception.PasswordsDontMatchException;
import com.ula.authentication.service.exception.RequiredFieldException;
import com.ula.authentication.service.exception.UserException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public interface UserService {

	Optional<User> getById(Long id) throws UserException;

	Optional<User> getByIdTrashed(Long id) throws UserException;

	List<User> getAll();

	List<User> getAllWithTrashed();

	Optional<User> getByUsername(String username) throws UserException;

	Optional<User> getByUsernameAndPassword(String username, String password) throws UserException;

	Optional<User> getByEmail(String email) throws UserException;

	Optional<User> getByEmailAndPassword(String email, String password) throws UserException;

	String add(UserDTO userDTO) throws UserException, RequiredFieldException;

	String updatePassword(UserDTO userDTO) throws UserException;

	HashMap<String, String> login(UserDTO userDTO) throws UserException, UsernameNotFoundException;

	String delete(Long id) throws UserException;

	String restore(Long id) throws UserException;

	UserDTO getUserData(String username) throws UserException;

	void verifyEmail(User user);

	void checkForPasswords(String password, String confirmPassword)
			throws PasswordsDontMatchException;

	void checkTermsAndConditions(String value) throws UserException;

	/*
	 * @TODO - force delete
	 */

}
