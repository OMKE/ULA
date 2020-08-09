package com.ula.authentication.api.v1.controller;

import com.ula.authentication.api.v1.request.LoginRequest;
import com.ula.authentication.api.v1.request.MethodArgumentExceptionResolver;
import com.ula.authentication.dto.model.UserDTO;
import com.ula.authentication.dto.response.Response;
import com.ula.authentication.service.exception.RequiredFieldException;
import com.ula.authentication.service.exception.UserException;
import com.ula.authentication.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController
{

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Response<Object> login(
            @RequestBody @Valid LoginRequest loginRequest, Errors errors)
    {

        try
        {
            MethodArgumentExceptionResolver.checkFields(loginRequest.getUsername(),
                    loginRequest.getPassword());

            UserDTO userDTO = new UserDTO().setUsername(loginRequest.getUsername())
                    .setPassword(loginRequest.getPassword());

            return Response.ok().setPayload(userService.login(userDTO));
        } catch (UserException e)
        {
            return Response.wrongCredentials()
                    .setErrors(MethodArgumentExceptionResolver.resolve(errors, e));
        } catch (RequiredFieldException e)
        {
            return Response.badRequest()
                    .setErrors(MethodArgumentExceptionResolver.resolve(errors));
        }

    }

    @GetMapping("/check")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Response<Object> check(Authentication authentication)
    {
        try
        {
            return Response.ok().setPayload(userService.getUserData(authentication.getName()));
        } catch (UserException e)
        {
            return Response.accessDenied().setErrors(e.getMessage());
        }
    }
}
