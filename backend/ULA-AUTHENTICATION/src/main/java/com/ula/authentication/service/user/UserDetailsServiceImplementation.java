package com.ula.authentication.service.user;

import com.ula.authentication.domain.model.User;
import com.ula.authentication.domain.model.UserPermission;
import com.ula.authentication.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;



@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	UserServiceImpl userService;



	/*
	 * @TODO - login with email or username
	 * 
	 * @Transactional public UserDetails loadUserByEmail(String email) throws
	 * UserException {
	 * 
	 * Optional<User> user = userService.getByEmail(email);
	 * 
	 * if (user.isPresent()) { ArrayList<GrantedAuthority> grantedAuthorities = new
	 * ArrayList<>(); for (UserPermission userPermission :
	 * user.get().getUserPermissions()) { grantedAuthorities .add(new
	 * SimpleGrantedAuthority(userPermission.getPermission().getTitle())); } return
	 * new
	 * org.springframework.security.core.userdetails.User(user.get().getUsername(),
	 * user.get().getPassword(), grantedAuthorities); }
	 * 
	 * return null;
	 * 
	 * }
	 */

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{

		Optional<User> user;
		try
		{
			user = userService.getByUsername(username);
		} catch (UserNotFoundException e)
		{
			user = null;
			throw new UsernameNotFoundException("User with given username not found");
		}

		if (user.isPresent())
		{
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			for (UserPermission userPermission : user.get().getUserPermissions())
			{
				grantedAuthorities
						.add(new SimpleGrantedAuthority(userPermission.getPermission().getTitle()));
			}
			return new org.springframework.security.core.userdetails.User(user.get().getUsername(),
					user.get().getPassword(), grantedAuthorities);
		}

		return null;
	}

	/*
	 * public UserDetails loadByEmail(String email) { Optional<User> user; try {
	 * user = userService.getByEmail(email); } catch (UserException e) { user =
	 * null; throw new UsernameNotFoundException("User with given email not found");
	 * } if (user.isPresent()) { ArrayList<GrantedAuthority> grantedAuthorities =
	 * new ArrayList<>(); for (UserPermission userPermission :
	 * user.get().getUserPermissions()) { grantedAuthorities .add(new
	 * SimpleGrantedAuthority(userPermission.getPermission().getTitle())); } return
	 * new
	 * org.springframework.security.core.userdetails.User(user.get().getUsername(),
	 * user.get().getPassword(), grantedAuthorities); }
	 * 
	 * return null; }
	 */
}
