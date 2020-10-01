package com.ula.authentication.api.v1.controller;

import com.ula.authentication.api.v1.request.UpdateUserFirstAndLastNameRequest;
import com.ula.authentication.api.v1.request.UpdateUserPasswordRequest;
import com.ula.authentication.service.exception.*;
import com.ula.authentication.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;
import org.ula.core.domain.model.UserDTO;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@Validated
public class UserController extends BaseController
{

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/user")
    public Response<Object> index()
    {
        return Response.ok().setPayload(this.userService.index());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/user/{id}")
    public Response<Object> show
    (
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok().setPayload(this.userService.show(id));
        } catch (UserNotFoundException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }

    }



    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/me")
    public Response<Object> me(Authentication authentication)
    {
        try {
            return Response.ok().setPayload(this.userService.getUserData(authentication.getName()));
        } catch (UserException | UserNotFoundException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }
    }


    @PreAuthorize("hasAuthority('USER')")
    @PutMapping("/me")
    public Response<Object> updateFirstAndLastName
    (
            Authentication authentication,
            @Valid @RequestBody UpdateUserFirstAndLastNameRequest updateUserFirstAndLastNameRequest,
            Errors errors
    )
    {
        UserDTO userDTO = new UserDTO()
                    .setUsername(authentication.getName())
                    .setFirstName(this.sanitize(updateUserFirstAndLastNameRequest.getFirstName()))
                    .setLastName(this.sanitize(updateUserFirstAndLastNameRequest.getLastName()));
        try {
            return Response.ok().setPayload(this.userService.update(userDTO));
        } catch (UserNotFoundException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }

    }

    @PreAuthorize("hasAuthority('USER')")
    @PutMapping("/me/change-password")
    public Response<Object> updatePassword
    (
                    Authentication authentication,
                    @Valid @RequestBody UpdateUserPasswordRequest updateUserPasswordRequest,
                    Errors errors
    )
    {
        UserDTO userDTO = new UserDTO()
                    .setUsername(authentication.getName())
                    .setPassword(passwordEncoder.encode(updateUserPasswordRequest.getPassword()));

        try {
            userService.checkForPasswords(updateUserPasswordRequest.getPassword(), updateUserPasswordRequest.getConfirmPassword());
            userService.checkForOldPassword(authentication.getName(), updateUserPasswordRequest.getOldPassword());
            return Response.ok().setPayload(userService.updatePassword(userDTO));
        } catch (PasswordsDontMatchException | UserException | UserNotFoundException | WrongOldPasswordException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }
    }


    /*
        @TODO
        - Update photo,
        first send the request to post new photo, hold in variable photo that was before,
        then call the service and delete the old photo
     */

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/me/profile-image")
    public Response<Object> storeProfileImage
    (
            Authentication authentication,
            @RequestParam("image") MultipartFile image,
            @RequestHeader("Authorization") String authHeader
    )
    {
        try {
            return Response.ok().setPayload(this.userService.storeProfileImage(authentication.getName(), authHeader, image));
        } catch (IOException | UserNotFoundException | FileStorageException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }
    }

    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping("/me/profile-image")
    public Response<Object> deleteProfileImage
    (
            Authentication authentication,
            @RequestHeader("Authorization") String authHeader
    )
    {
        try {
            return Response.ok().setPayload(this.userService.deleteProfileImage(authentication.getName(), authHeader));
        } catch (UserNotFoundException | ProfileImageNotFoundException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }
    }


}
