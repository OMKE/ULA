package com.ula.authentication.api.v1.controller;

import com.ula.authentication.api.v1.request.LoginRequest;
import com.ula.authentication.api.v1.request.MethodArgumentExceptionResolver;
import com.ula.authentication.dto.model.UserDTO;
import com.ula.authentication.dto.response.Response;
import com.ula.authentication.service.exception.RequiredFieldException;
import com.ula.authentication.service.exception.UserException;
import com.ula.authentication.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
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
            /*
                We're checking that all fields are not null and within rules of validation
             */
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

}
