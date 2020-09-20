package com.ula.faculty.api.v1.controller;


import com.ula.faculty.api.v1.request.StoreAndUpdateFacultyRequest;
import com.ula.faculty.dto.model.FacultyDTO;
import com.ula.faculty.service.exception.FacultyNotFoundException;
import com.ula.faculty.service.faculty.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;

import javax.validation.Valid;


@RestController
@Validated
public class FacultyController extends BaseController
{

    @Autowired
    private FacultyService facultyService;

    /*
        Return a listing of the resource

    */
    @GetMapping
    public Response<Object> index()
    {
            return Response.ok().setPayload(facultyService.index());
    }


    /* 
        Return one resource
    */
    @GetMapping(path = "/{id}")
    public Response<Object> show
    (
            @PathVariable("id") Long id
    )
    {

        try {
            return Response.ok().setPayload(facultyService.show(id));
        } catch (FacultyNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @GetMapping(path = "/slug/{slug}")
    public Response<Object> showBySlug
    (
            @PathVariable("slug") String slug
    )
    {
        try {
            return Response.ok().setPayload(this.facultyService.showBySlug(slug));
        } catch (FacultyNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }


    /*
        Store a newly created resource in storage
        @param - Request class of resource
        @return - response
    */


    @Authorized("ADMIN")
    @PostMapping("")
    public Response<Object> store
    (
            @Valid @RequestBody StoreAndUpdateFacultyRequest postRequest,
            Errors errors
    )
    {
        FacultyDTO facultyDTO = new FacultyDTO()
                    .setName(this.sanitize(postRequest.getName()))
                    .setCampusId(postRequest.getCampusId());

        return Response.ok().setPayload(this.facultyService.store(facultyDTO));
    }



    /*
        Update an existing resource
    */

    @Authorized("ADMIN")
    @PutMapping(path = "/{id}")
    public Response<Object> update
    (
            @PathVariable("id") Long id,
            @Valid @RequestBody StoreAndUpdateFacultyRequest putRequest,
            Errors errors
    )
    {
        FacultyDTO facultyDTO = new FacultyDTO()
                    .setName(this.sanitize(putRequest.getName()))
                    .setCampusId(putRequest.getCampusId());

        try {
            return Response.ok().setPayload(this.facultyService.update(id, facultyDTO));
        } catch (FacultyNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    
    /*
        Delete a resource
        @param - Long - resource Id
    */

    @Authorized("ADMIN")
    @DeleteMapping(path = "/{id}")
    public Response<Object> delete
    (
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok().setPayload(this.facultyService.delete(id));
        } catch (FacultyNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }


    
    

    
}
