package com.ula.service.user;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ula.domain.model.User;
import com.ula.domain.model.UserPermission;
import com.ula.domain.repository.PermissionRepository;
import com.ula.domain.repository.UserRepository;
import com.ula.dto.model.UserDTO;
import com.ula.service.exception.UserException;
import com.ula.util.AssertUtils;
import com.ula.util.JWTUtils;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository userRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private JWTUtils jwt;

	@Autowired
	private UserDetailsServiceImplementation userDetailsService;

	@Autowired
	private AuthenticationManager AuthenticationManager;

	@Override
	public HashMap<String, String> login(UserDTO userDTO) throws UserException {

		try
		{

			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					userDTO.getUsername(), userDTO.getPassword());

			UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getUsername());


			Authentication authentication = AuthenticationManager.authenticate(token);

			SecurityContextHolder.getContext().setAuthentication(authentication);



			String userToken = jwt.generateToken(userDetails);

			HashMap<String, String> data = new HashMap<>();
			data.put("token", userToken);


			return data;
		} catch (InternalAuthenticationServiceException e)
		{
			throw new UserException("Username or password is incorrect");
		}


	}

    
	@Override
	public List<User> getAll() {

		return userRepository.findAll();
	}

	@Override
	public Optional<User> getById(Long id) throws UserException {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserException(String.format("User with id: '%s' does not exist", id));
		} else {
			return user;
		}
	}


	@Transactional
	@Override
	public String add(UserDTO userDTO) throws UserException {
		AssertUtils.notNull(userDTO, userDTO.getUsername(), userDTO.getPassword(),
				userDTO.getEmail(), userDTO.getFirstName(), userDTO.getLastName());

		Optional<User> foundedUser = userRepository.findByUsername(userDTO.getUsername());
		if (foundedUser.isPresent()) {
			throw new UserException(String.format("User with username: '%s' already exists",
					userDTO.getUsername()));
		} else {
			foundedUser = userRepository.findByEmail(userDTO.getEmail());
			if (foundedUser.isPresent()) {
				throw new UserException(
						String.format("User with email: '%s' already exists", userDTO.getEmail()));
			} else {
				User user = new User().setUsername(userDTO.getUsername())
						.setPassword(userDTO.getPassword()).setEmail(userDTO.getEmail())
						.setFirstName(userDTO.getFirstName()).setLastName(userDTO.getLastName())
						.setProfileImage("user-icon.png");

				user = userRepository.save(user);
				user.setUserPermissions(new HashSet<>());
				user.getUserPermissions()
						.add(new UserPermission(null, user, permissionRepository.ROLE_USER()));
				userRepository.save(user);
			}

		}

		return null;
	}

	@Override
	public Optional<User> getByUsername(String username) throws UserException {
		
		Optional<User> user = userRepository.findByUsername(username);
		if(user.isEmpty()) {
			throw new UserException(
					String.format("User with given username: '%s' does not exist", username));
		} else {
			return user;
		}
		
	}

	@Override
	public Optional<User> getByUsernameAndPassword(String username, String password)
			throws UserException {
		Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
		if(user.isEmpty()) {
			throw new UserException(String.format(
					"User with given username and password: '%s': '%d' does not exist", username,
					password));
		} else {
			return user;
		}
	}

	@Override
	public Optional<User> getByEmail(String email) throws UserException {

		Optional<User> user = userRepository.findByEmail(email);
		if (user.isEmpty()) {
			throw new UserException(
					String.format("User with given email: '%s' does not exist", email));
		} else {
			return user;
		}
	}

	@Override
	public Optional<User> getByEmailAndPassword(String email, String password)
			throws UserException {

		Optional<User> user = userRepository.findByUsernameAndPassword(email, password);
		if (user.isEmpty()) {
			throw new UserException(
					String.format("User with given email and password: '%s': '%d' does not exist",
							email, password));
		} else {
			return user;
		}
	}


	@Transactional
	@Override
	public String delete(Long id) throws UserException {
		Optional<User> user;
		try {
			user = this.getById(id);
			userRepository.deleteById(id);
		} catch (UserException e) {
			throw new UserException(String.format(
					"User with given id: '%s' could not be deleted because it does not exist", id));
		}
		return null;

	}

	@Transactional
	@Override
	public String restore(Long id) throws UserException {
		Optional<User> user;
		try {
			user = this.getByIdTrashed(id);
			userRepository.restoreById(id);
		} catch (UserException e) {
			throw new UserException(String.format(
					"User with given id: '%s' could not be restored because it's not soft deleted",
					id));
		}

		return null;
	}

	@Override
	public Optional<User> getByIdTrashed(Long id) throws UserException {

		Optional<User> user = userRepository.findByIdTrashed(id);
		if (user.isEmpty()) {
			throw new UserException(
					String.format("Soft deleted user with given id: '%s' does not exist", id));
		} else {
			return user;
		}

	}

	@Override
	public List<User> getAllWithTrashed() {
		return userRepository.findAllWithTrashed();
	}


	@Transactional
	@Override
	public String updatePassword(UserDTO userDTO) throws UserException
	{
		Optional<User> user;
		try
		{
			user = this.getById(userDTO.getId());
			user.get().setPassword(userDTO.getPassword());

			userRepository.save(user.get());
			return "Password changed successfully";
			
		} catch (UserException e)
		{
			throw new UserException(e.getMessage());
		}

	}

}