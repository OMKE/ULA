package com.ula.authentication.api.v1.controller;

import com.ula.authentication.api.v1.request.StoreContentCreatorRequest;
import com.ula.authentication.service.contentcreator.ContentCreatorService;
import com.ula.authentication.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;

import javax.validation.Valid;

@RestController
public class ContentCreatorController extends BaseController
{

    @Autowired
    private ContentCreatorService contentCreatorService;

    @Authorized("ADMIN")
    @GetMapping("/content-creator")
    public Response<Object> index(Pageable pageable)
    {
        return Response.ok().setPayload(this.contentCreatorService.index(pageable));
    }

    @Authorized("ADMIN")
    @GetMapping("/content-creator/{id}")
    public Response<Object> show
    (
        @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok().setPayload(this.contentCreatorService.show(id));
        } catch (ContentCreatorNotFoundException e) {
            return Response.exception().setErrors(this.errors(e.getMessage()));
        }
    }

    @Authorized("ADMIN")
    @PostMapping("/content-creator")
    public Response<Object> store
    (
            @Valid @RequestBody StoreContentCreatorRequest request,
            Errors errors
    )
    {
        try {
            return Response.ok().setPayload(this.contentCreatorService.store(request.getUserId()));
        } catch (UserNotFoundException | UserIsAlreadyContentCreator | ContentCreatorAlreadyExists e) {
            return Response.exception().setPayload(this.errors(e.getMessage()));
        }
    }

    @Authorized("ADMIN")
    @DeleteMapping("/content-creator/{id}")
    public Response<Object> delete
    (
        @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok().setPayload(this.contentCreatorService.delete(id));
        } catch (ContentCreatorNotFoundException | UserPermissionException e) {
            return Response.exception().setErrors(this.errors(e.getMessage()));
        }
    }

}
