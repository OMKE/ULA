package com.ula.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ula.repositories.PermissionRepository;
import com.ula.repositories.UserRepository;

@Controller
@RequestMapping(path = "/api/v1/auth/register")
public class RegisterController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

//	@PostMapping
//	ResponseEntity<UserDTO> register(@RequestBody User user){
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		
//		user = userRepository.save(user);
//		user.setUserPermissions(new HashSet<>());
//		user.getUserPermissions().add(new UserPermission(null, user, permissionRepository.findById(id)))
//	}
}
