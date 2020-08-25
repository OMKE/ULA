package com.ula.university.api.v1.controller;


import com.ula.university.service.exception.UniversityInformationNotFoundException;
import com.ula.university.service.exception.UniversityNotFoundException;
import com.ula.university.service.university.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.api.response.Response;


@RestController
public class UniversityController 
{

    @Autowired
    private UniversityService universityService;

    /*
        Return a listing of the resource
    */
    @GetMapping("")
    public Response<Object> index()
    {

        try {
            return Response.ok().setPayload(universityService.index());
        } catch (UniversityNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        } catch (UniversityInformationNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }

    }



}
