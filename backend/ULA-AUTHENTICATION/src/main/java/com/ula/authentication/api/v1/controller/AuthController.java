package com.ula.authentication.api.v1.controller;

import com.ula.authentication.dto.model.ULAUserDTO;
import com.ula.authentication.dto.response.Response;
import com.ula.authentication.service.auth.AuthService;
import com.ula.authentication.service.exception.UserException;
import com.ula.authentication.service.exception.UserNotFoundException;
import com.ula.authentication.service.user.UserService;
import com.ula.authentication.util.RoleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController
{

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;
    /*
        Route for services only
     */
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/user")
    public ULAUserDTO getUser(Authentication authentication, @RequestBody String authorizeRoles)
    {
        RoleResolver roleResolver = new RoleResolver(authorizeRoles);
        return authService.getUser(authentication.getName(), roleResolver.getRoles());
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/me")
    public Response<Object> getUser(Authentication authentication)
    {
        try {
            return Response.ok().setPayload(userService.getUserData(authentication.getName()));
        } catch (UserException | UserNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
