package com.ula.faculty.api.v1.controller;

import com.ula.faculty.dto.response.Response;
import com.ula.faculty.service.exception.FacultyNotFoundException;
import com.ula.faculty.service.faculty.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class FacultyController 
{

    @Autowired
    private FacultyService facultyService;

    /*
        Return a listing of the resource

    */
    @GetMapping(produces = "application/json")
    public Response<Object> index(@RequestParam(value = "studyPrograms", required = false) Optional<String> withStudyPrograms) {
        if(withStudyPrograms.isPresent() && withStudyPrograms.get().equals("fetch"))
        {
            return Response.ok().setPayload(facultyService.indexWithStudyPrograms());
        } else {
            return Response.ok().setPayload(facultyService.index());
        }

    }


    /* 
        Return one resource
    */
    @GetMapping(path = "/{id}")
    public Response<Object> show(@PathVariable("id") Long id) {

        try {
            return Response.ok().setPayload(facultyService.show(id));
        } catch (FacultyNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }


    /*
        Store a newly created resource in storage
        @param - Request class of resource
        @return - response
    */

    /*
    @PostMapping
    public Response<Object> store(Object object) {

        return Response.ok();
    }
    */


    /*
        Update an existing resource
    */

    /*
    @PutMapping(path = "/{id}") 
    public Response<Object> update(@PathVariable("id") Long id, Object object){

        return Response.ok();
    }
    */
    
    /*
        Delete a resource
        @param - Long - resource Id
    */
    /*
    @DeleteMapping(path = "/{id}")
    public Response<Object> delete(@PathVariable("id") Long id) {

        return Response.ok();
    }
    */

    
    

    
}
