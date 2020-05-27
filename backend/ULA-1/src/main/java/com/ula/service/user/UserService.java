package com.ula.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ula.domain.model.User;
import com.ula.dto.model.UserDTO;
import com.ula.service.exception.UserException;

public interface UserService {

	Optional<User> getById(Long id) throws UserException;

	Optional<User> getByIdTrashed(Long id) throws UserException;

	List<User> getAll();

	List<User> getAllWithTrashed();

	Optional<User> getByUsername(String username) throws UserException;

	Optional<User> getByUsernameAndPassword(String username, String password) throws UserException;

	Optional<User> getByEmail(String email) throws UserException;

	Optional<User> getByEmailAndPassword(String email, String password) throws UserException;

	String add(UserDTO userDTO) throws UserException;

	String updatePassword(UserDTO userDTO) throws UserException;

	HashMap<String, String> login(UserDTO userDTO) throws UserException, UsernameNotFoundException;

	String delete(Long id) throws UserException;

	String restore(Long id) throws UserException;

	UserDTO getUserData(String username) throws UserException;

	void verifyEmail(User user);

	/*
	 * @TODO - force delete
	 */

}
