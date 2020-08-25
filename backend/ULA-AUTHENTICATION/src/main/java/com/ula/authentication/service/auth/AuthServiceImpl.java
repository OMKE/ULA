package com.ula.authentication.service.auth;

import com.ula.authentication.domain.model.User;
import com.ula.authentication.mapper.ULAUserMapper;
import com.ula.authentication.service.exception.UserNotAuthorizedException;
import com.ula.authentication.service.exception.UserNotFoundException;
import com.ula.authentication.service.user.UserService;
import com.ula.authentication.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.ula.core.domain.model.ULAUserDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
    public ULAUserDTO getUser(String username, ArrayList<String> roles)
    {
        try {
            return ULAUserMapper.map(this.verifyRoles(username, roles));
        } catch (UserNotAuthorizedException | UserNotFoundException e) {
            return null;
        }
    }

    @Override
    public User verifyRoles(String username, ArrayList<String> roles) throws UserNotAuthorizedException, UserNotFoundException
    {

        User user = userService.getByUsername(username).get();
        ArrayList<String> userRoles = user.getUserPermissions()
                .stream()
                .map(userPermission -> userPermission.getPermission().getTitle())
                .collect(Collectors.toCollection(ArrayList::new));


        boolean foundRole = false;

        for (String role: roles)
        {
            for(String userRole: userRoles)
            {
                if(role.equals(userRole))
                {
                    foundRole = true;
                }
            }
        }

        if(foundRole)
        {
            return user;
        } else {
            System.out.println(roles);
            System.out.println(userRoles);
            throw new UserNotAuthorizedException("User is not authorized for given action");
        }

    }
}
