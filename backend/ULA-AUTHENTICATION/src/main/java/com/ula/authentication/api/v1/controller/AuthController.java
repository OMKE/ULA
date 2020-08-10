package com.ula.authentication.api.v1.controller;

import com.ula.authentication.dto.model.ULAUserDTO;
import com.ula.authentication.service.user.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController
{

    @Autowired
    private AuthService authService;

    @PostMapping("/authorize")
    public ULAUserDTO authorizeToken(@RequestParam String token)
    {
        return authService.authorize(token);
    }
}
