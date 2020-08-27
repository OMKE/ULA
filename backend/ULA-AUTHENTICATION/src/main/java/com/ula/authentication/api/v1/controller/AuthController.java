package com.ula.authentication.api.v1.controller;


import com.ula.authentication.service.auth.AuthService;
import com.ula.authentication.util.RoleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.domain.model.ULAUserDTO;

import javax.validation.Valid;

@RestController
@Validated
public class AuthController
{

    @Autowired
    private AuthService authService;


    /*
        Route for services only
     */
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/user")
    public ULAUserDTO getUser
    (
            Authentication authentication,
            @RequestBody @Valid String authorizeRoles)
    {
        RoleResolver roleResolver = new RoleResolver(authorizeRoles);
        return authService.getUser(authentication.getName(), roleResolver.getRoles());
    }
}
