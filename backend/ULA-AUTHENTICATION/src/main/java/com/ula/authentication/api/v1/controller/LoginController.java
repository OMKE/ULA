package com.ula.authentication.api.v1.controller;

import com.ula.authentication.api.v1.request.LoginRequest;
import com.ula.authentication.service.exception.UserException;
import com.ula.authentication.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;
import org.ula.core.domain.model.UserDTO;

import javax.validation.Valid;

@RestController
@Validated
public class LoginController extends BaseController
{

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Response<Object> login
    (
            @RequestBody @Valid LoginRequest loginRequest,
            Errors errors
    )
    {
        try
        {

            UserDTO userDTO = new UserDTO().setUsername(this.sanitize(loginRequest.getUsername()))
                    .setPassword(loginRequest.getPassword());

            return Response.ok().setPayload(userService.login(userDTO));
        } catch (UserException e)
        {
            return Response.wrongCredentials()
                    .setErrors(e.getMessage());
        }

    }

}
