package com.ula.authentication.api.v1.controller;

import com.ula.authentication.api.v1.request.StoreAdministratorRequest;
import com.ula.authentication.service.admin.AdministratorService;
import com.ula.authentication.service.exception.AdministratorNotFoundException;
import com.ula.authentication.service.exception.UserIsAlreadyAdministratorException;
import com.ula.authentication.service.exception.UserNotFoundException;
import com.ula.authentication.service.exception.UserPermissionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;

import javax.validation.Valid;

@RestController
@Validated
public class AdministratorController extends BaseController
{

    /*
        @TODO
        Add logger to every admin action
     */

    @Autowired
    private AdministratorService administratorService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public Response<Object> index()
    {
        return Response.ok().setPayload(administratorService.index());
    }
    
    @GetMapping("/admin/{id}")
    public Response<Object> show(@PathVariable("id") Long id)
    {
        try {
            return Response.ok().setPayload(this.administratorService.show(id));
        } catch (AdministratorNotFoundException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }
    }
    

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/admin")
    public Response<Object> store
    (
        @Valid @RequestBody StoreAdministratorRequest storeAdministratorRequest,
        Errors errors
    )
    {
        try {
            return Response.ok().setPayload(this.administratorService.store(storeAdministratorRequest.getUserId()));
        } catch (UserNotFoundException | UserIsAlreadyAdministratorException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/admin/{userId}")
    public Response<Object> delete
    (
        @PathVariable("userId") Long userId
    )
    {
        try {
            return Response.ok().setPayload(this.administratorService.delete(userId));
        } catch (UserNotFoundException | UserPermissionException | AdministratorNotFoundException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/admin/{userId}/restore")
    public Response<Object> restore
    (
        @PathVariable("userId") Long userId
    )
    {
        try {
            return Response.ok().setPayload(this.administratorService.restore(userId));
        } catch (UserNotFoundException | UserPermissionException | AdministratorNotFoundException e) {
            return Response.exception().setErrors(errors(e.getMessage()));
        }
    }
}
