package com.ula.authentication.service.user;

import com.ula.authentication.domain.model.User;
import com.ula.authentication.domain.model.UserPermission;
import com.ula.authentication.domain.repository.PermissionRepository;
import com.ula.authentication.domain.repository.UserRepository;
import com.ula.authentication.feign.StaticContentServiceFeignClient;
import com.ula.authentication.service.auth.AuthService;
import com.ula.authentication.service.emailverification.EmailVerificationService;
import com.ula.authentication.service.exception.*;
import com.ula.authentication.util.IpAddressUtils;
import com.ula.authentication.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.ula.core.api.response.Response;
import org.ula.core.domain.model.UserDTO;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


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

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmailVerificationService emailVerificationService;


	@Autowired
	private StaticContentServiceFeignClient staticContentServiceFeignClient;

	@Autowired
	private AuthService authService;

	@Override
	public HashMap<String, String> login(UserDTO userDTO)
			throws UserException, UsernameNotFoundException
	{

		try
		{

			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					userDTO.getUsername(), userDTO.getPassword());

			UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getUsername());

			Authentication authentication = AuthenticationManager.authenticate(token);

			SecurityContextHolder.getContext().setAuthentication(authentication);

			User user = this.userRepository.findByUsernameAndDeletedFalse(userDTO.getUsername())
						.orElseThrow
								(
									() -> new UserException(String.format("User with username: %s not found."))
								);
			user.setIpAddress(IpAddressUtils.getClientIpAddressIfServletRequestExist());
			userRepository.save(user);

			String userToken = jwt.generateToken(userDetails);

			HashMap<String, String> data = new HashMap<>();
			data.put("token", userToken);


			return data;
		} catch (InternalAuthenticationServiceException | UsernameNotFoundException e)
		{
			throw new UserException(
					"The username and password you entered do not match our records. Check them out and try again");
		}


	}

    
	@Override
	public List<User> getAll() {

		return userRepository.findAll();
	}

	@Override
	public Optional<User> getById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException(String.format("User with id: '%s' does not exist", id));
		} else {
			return user;
		}
	}


	@Transactional
	@Override
	public String add(UserDTO userDTO) throws UserConflictException
	{
		

		Optional<User> foundedUser = userRepository.findByUsernameAndDeletedFalse(userDTO.getUsername());
		if (foundedUser.isPresent()) {
			throw new UserConflictException(String.format("User with username: '%s' already exists",
					userDTO.getUsername()));
		} else {
			foundedUser = userRepository.findByEmail(userDTO.getEmail());
			if (foundedUser.isPresent()) {
				throw new UserConflictException(
						String.format("User with email: '%s' already exists", userDTO.getEmail()));
			} else {
				User user = new User().setUsername(userDTO.getUsername())
						.setPassword(userDTO.getPassword()).setEmail(userDTO.getEmail())
						.setFirstName(userDTO.getFirstName()).setLastName(userDTO.getLastName())
						.setProfileImage("users/user-icon.png");

				user = userRepository.save(user);
				user.setUserPermissions(new HashSet<>());
				user.getUserPermissions()
						.add(new UserPermission(null, user, permissionRepository.ROLE_USER()));
				userRepository.save(user);
//				Generate email verification token
				emailVerificationService.generate(user);
				return "User registered successfully";
			}

		}
	}

	@Override
	public String update(UserDTO userDTO) throws UserNotFoundException
	{
		User user = this.getByUsername(userDTO.getUsername()).get();
		user.setFirstName(userDTO.getFirstName())
			.setLastName(userDTO.getLastName());
		this.userRepository.save(user);
		return "User has been updated";
	}

	@Override
	public Optional<User> getByUsername(String username) throws UserNotFoundException
	{
		
		Optional<User> user = userRepository.findByUsernameAndDeletedFalse(username);
		if(user.isEmpty()) {
			throw new UserNotFoundException(
					String.format("User with given username: '%s' does not exist", username));
		} else {
			return user;
		}
		
	}

	@Override
	public Optional<User> getByUsernameAndPassword(String username, String password)
			throws UserNotFoundException
	{
		Optional<User> user = userRepository.findByUsernameAndPasswordAndDeletedFalse(username, password);
		if(user.isEmpty()) {
			throw new UserNotFoundException(String.format(
					"User with given username and password: '%s': '%d' does not exist", username,
					password));
		} else {
			return user;
		}
	}

	@Override
	public Optional<User> getByEmail(String email) throws UserNotFoundException
	{

		Optional<User> user = userRepository.findByEmail(email);
		if (user.isEmpty()) {
			throw new UserNotFoundException(
					String.format("User with given email: '%s' does not exist", email));
		} else {
			return user;
		}
	}

	@Override
	public Optional<User> getByEmailAndPassword(String email, String password)
			throws UserNotFoundException
	{

		Optional<User> user = userRepository.findByUsernameAndPasswordAndDeletedFalse(email, password);
		if (user.isEmpty()) {
			throw new UserNotFoundException(
					String.format("User with given email and password: '%s': '%d' does not exist",
							email, password));
		} else {
			return user;
		}
	}



	@Transactional
	@Override
	public String delete(Long id) throws UserNotFoundException
	{
		Optional<User> user;
		try {
			user = this.getById(id);
			userRepository.deleteById(id);
		} catch (UserNotFoundException e) {
			throw new UserNotFoundException(String.format(
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
		try {
			User user = this.getByUsername(userDTO.getUsername()).get();
			user.setPassword(userDTO.getPassword());
			userRepository.save(user);
			return "Password has been changed";
		} catch (UserNotFoundException e) {
			throw new UserException(e.getMessage());
		}
	}

	@Transactional
	@Override
	public void verifyEmail(User user)
	{
		user.setEmailVerified(true);
		userRepository.save(user);

	}

	@Override
	public UserDTO getUserData(String username) throws UserNotFoundException
	{
		Optional<User> user;
		try
		{
			user = this.getByUsername(username);
		} catch (UserNotFoundException e)
		{
			throw new UserNotFoundException(e.getMessage());
		}
		return new UserDTO().setId(user.get().getId()).setUsername(username).setEmail(user.get()
				.getEmail())
				.setFirstName(user.get().getFirstName()).setLastName(user.get().getLastName())
				.setProfileImage(user.get().getProfileImage());

	}



	@Override
	public void checkForPasswords(String password, String confirmPassword)
			throws PasswordsDontMatchException
	{
		if (!password.equals(confirmPassword))
		{
			throw new PasswordsDontMatchException("Passwords don't match");
		}
	}

	@Override
	public boolean checkForOldPassword(String username, String oldPassword) throws UserNotFoundException, WrongOldPasswordException
	{
		User user = this.getByUsername(username).get();
		if(this.passwordEncoder.matches(oldPassword, user.getPassword()))
		{
			return true;
		} else {
			throw new WrongOldPasswordException("Wrong old password");
		}
	}

	@Override
	public void checkTermsAndConditions(String value) throws UserException
	{
		if (!value.equals("true") && !value.equals("false"))
		{
			throw new UserException("Illegal value");
		} else if (value.equals("false"))
		{
			throw new UserException("Terms and Condtions must be accepted in order to register");
		}

	}

	@Override
	public String storeProfileImage(String username, String token, MultipartFile image)
	throws IOException, UserNotFoundException, FileStorageException
	{
		User user = this.getByUsername(username).get();
		Response<Object> profileImageResponse = this.staticContentServiceFeignClient.addProfileImage(token, image);
		String fileName = (String) profileImageResponse.getPayload();

		if(fileName == null)
		{
			throw new FileStorageException((String) profileImageResponse.getErrors());
		} else {
			user.setProfileImage("users/" + fileName);
			this.userRepository.save(user);

			return "User photo has been stored";
		}
	}

	@Override
	public String deleteProfileImage(String username, String token) throws UserNotFoundException, ProfileImageNotFoundException
	{
		User user = this.getByUsername(username).get();
		String oldImage = "";
		if(!user.getProfileImage().equals("user-icon.png") || !user.getProfileImage().equals("admin-icon.png"))
		{
			oldImage = user.getProfileImage();
			Response response = this.staticContentServiceFeignClient.deleteProfileImage(token, username, Response.ok().setPayload(oldImage));
			if(response.getPayload() != null)
			{
				if(authService.isAdmin(user.getUsername())){
					user.setProfileImage("admin-icon.png");
				} else {
					user.setProfileImage("user-icon.png");
				}
				userRepository.save(user);
				String message = (String) response.getPayload();
				return message;
			} else {
				throw new ProfileImageNotFoundException(response.getErrors().toString());
			}
		} else {
			throw new ProfileImageNotFoundException("You don't have a profile image to delete");
		}
	}


}
