package com.ula.authentication.service.user;

import com.ula.authentication.domain.model.User;
import com.ula.authentication.domain.model.UserPermission;
import com.ula.authentication.dto.model.ULAUserDTO;
import com.ula.authentication.service.exception.UserException;
import com.ula.authentication.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService
{
    @Autowired
    private JWTUtils jwt;

    @Autowired
    private UserService userService;

    @Qualifier("userDetailsServiceImplementation")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public ULAUserDTO authorize(String token)
    {
        try {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwt.getUsername(token));

            if(this.jwt.validateToken(token, userDetails))
            {
                Optional<User> user = userService.getByUsername(userDetails.getUsername());
                ArrayList<String> roles = new ArrayList<>();
                for(UserPermission up: user.get().getUserPermissions())
                {
                    roles.add(up.getPermission().getTitle());
                }
                return new ULAUserDTO().setId(user.get().getId()).setUsername(user.get().getUsername()).setRoles(roles);
            } else {
                return null;
            }
        } catch (UsernameNotFoundException | UserException e) {
            return null;
        }

    }
}
