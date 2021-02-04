package com.ula.research.api.v1.controller;

import com.ula.research.api.v1.request.StoreResearchAuthorRequest;
import com.ula.research.dto.AuthorDTO;
import com.ula.research.service.author.AuthorService;
import com.ula.research.service.exception.AuthorNotFoundException;
import com.ula.research.service.exception.ResearchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;

import javax.validation.Valid;

@RestController
public class AuthorController extends BaseController
{
    @Autowired
    private AuthorService authorService;


    @Authorized("CONTENT_CREATOR")
    @PostMapping(value = "/{researchId}/author")
    public Response<Object> store
            (
                    @PathVariable("researchId") Long researchId,
                    @Valid @RequestBody StoreResearchAuthorRequest authorRequest,
                    Errors errors
            )
    {

        AuthorDTO authorDTO = new AuthorDTO()
                .setFirstName(this.sanitize(authorRequest.getFirstName()))
                .setLastName(this.sanitize(authorRequest.getLastName()));

        try {
            return Response.ok().setPayload(this.authorService.store(researchId, authorDTO));
        } catch (ResearchNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }


    @Authorized("CONTENT_CREATOR")
    @PutMapping(value = "/{researchId}/author/{authorId}")
    public Response<Object> update
    (
            @PathVariable("researchId") Long researchId,
            @PathVariable("authorId") Long authorId,
            @Valid @RequestBody StoreResearchAuthorRequest authorRequest,
            Errors errors
    )
    {

        AuthorDTO authorDTO = new AuthorDTO()
                .setFirstName(this.sanitize(authorRequest.getFirstName()))
                .setLastName(this.sanitize(authorRequest.getLastName()));

        try {
            return Response.ok().setPayload(this.authorService.update(researchId, authorId, authorDTO));
        } catch (ResearchNotFoundException | AuthorNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }


    @Authorized("CONTENT_CREATOR")
    @DeleteMapping(value = "/{researchId}/author/{authorId}")
    public Response<Object> delete
            (
                    @PathVariable("researchId") Long researchId,
                    @PathVariable("authorId") Long authorId
            )
    {

        try {
            return Response.ok().setPayload(this.authorService.delete(researchId, authorId));
        } catch (ResearchNotFoundException | AuthorNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

}
