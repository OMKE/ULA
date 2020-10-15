package com.ula.research.api.v1.controller;

import com.ula.research.api.v1.request.StoreResearchRequest;
import com.ula.research.api.v1.request.UpdateResearchRequest;
import com.ula.research.dto.AuthorDTO;
import com.ula.research.dto.ResearchDTO;
import com.ula.research.service.exception.ResearchNotFoundException;
import com.ula.research.service.research.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class ResearchController extends BaseController
{

    @Autowired
    private ResearchService researchService;

    @GetMapping("")
    public Response<Object> index(Pageable pageable)
    {
        return Response.ok().setPayload(this.researchService.index(pageable));
    }

    @GetMapping("/{id}")
    public Response<Object> show(@PathVariable("id") Long id)
    {
        try {
            return Response.ok().setPayload(this.researchService.show(id));
        } catch (ResearchNotFoundException e) {
            return Response.exception().setPayload(e.getMessage());
        }
    }

    @GetMapping("/{id}/author")
    public Response<Object> showAuthors(@PathVariable("id") Long id)
    {
        try {
            return Response.ok().setPayload(this.researchService.getAuthors(id));
        } catch (ResearchNotFoundException e) {
            return Response.exception().setPayload(e.getMessage());
        }
    }

    @Authorized("CONTENT_CREATOR")
    @PostMapping(value = "")
    public Response<Object> store
    (
            @Valid @RequestBody StoreResearchRequest researchRequest,
            Errors errors
    )
    {
        ResearchDTO researchDTO = new ResearchDTO()
                    .setTitle(this.sanitize(researchRequest.getTitle()))
                    .setContent(this.sanitize(researchRequest.getContent()))
                    .setPublicationDate(researchRequest.getPublicationDate())
                    .setAuthors
                    (
                        researchRequest
                                .getAuthors()
                                .stream()
                                .map(
                                        author ->
                                        new AuthorDTO()
                                        .setFirstName(this.sanitize(author.getFirstName()))
                                        .setLastName(this.sanitize(author.getLastName()))

                                    )
                                .collect(Collectors.toList())
                   );

        return Response.ok().setPayload(this.researchService.store(researchDTO));
    }

    @Authorized("CONTENT_CREATOR")
    @PostMapping(value = "/{id}/thumbnail-image")
    public Response<Object> addThumbnailImageToResearch
            (
                    @PathVariable("id") Long id,
                    @RequestParam("image") MultipartFile file
            )
    {

        try {
            return Response.ok().setPayload(this.researchService.storeThumbnailImage(id, file));
        } catch (ResearchNotFoundException e)
        {
            return Response.exception().setErrors(e.getMessage());
        }
    }


    @Authorized("CONTENT_CREATOR")
    @PostMapping(value = "/thumbnail-image")
    public Response<Object> storeThumbnailImage
            (
                    @RequestParam("image") MultipartFile file
            )
    {
        String fileName = "research/" + this.researchService.storeThumbnailImage(file);
        return Response.ok().setPayload(fileName);
    }

    @Authorized("CONTENT_CREATOR")
    @PutMapping("/{id}")
    public Response<Object> update
    (
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateResearchRequest updateResearchRequest,
            Errors errors
    )
    {
        ResearchDTO researchDTO = new ResearchDTO()
                .setTitle(this.sanitize(updateResearchRequest.getTitle()))
                .setContent(this.sanitize(updateResearchRequest.getContent()))
                .setPublicationDate(updateResearchRequest.getPublicationDate())
                .setThumbnail(updateResearchRequest.getThumbnailImage());

        try {
            return Response.ok().setPayload(this.researchService.update(id, researchDTO));
        } catch (ResearchNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("CONTENT_CREATOR")
    @DeleteMapping("/{id}")
    public Response<Object> delete
    (
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok().setPayload(this.researchService.delete(id));
        } catch (ResearchNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

}
