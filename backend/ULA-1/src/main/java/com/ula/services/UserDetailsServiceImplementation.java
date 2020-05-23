package com.ula.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ula.models.User;
import com.ula.models.UserPermission;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	UserService userService;

	@Transactional
	public UserDetails loadUserByEmail(String email) {

		Optional<User> user = userService.getUserByEmail(email);


		if (user.isPresent()) {
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			for (UserPermission userPermission : user.get().getUserPermissions()) {
				grantedAuthorities
						.add(new SimpleGrantedAuthority(userPermission.getPermission().getTitle()));
			}
			return new org.springframework.security.core.userdetails.User(user.get().getUsername(),
					user.get().getPassword(), grantedAuthorities);
		}


		return null;



	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = userService.getUserByUsername(username);

		if (user.isPresent()) {
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			for (UserPermission userPermission : user.get().getUserPermissions()) {
				grantedAuthorities
						.add(new SimpleGrantedAuthority(userPermission.getPermission().getTitle()));
			}
			return new org.springframework.security.core.userdetails.User(user.get().getUsername(),
					user.get().getPassword(), grantedAuthorities);
		}
		
		
		return null;
	}

}
