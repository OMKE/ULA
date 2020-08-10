package com.ula.university.api.v1.controller;

import com.ula.university.dto.response.Response;
import com.ula.university.service.exception.GalleryNotFoundException;
import com.ula.university.service.exception.UniversityNotFoundException;
import com.ula.university.service.university.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




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
        }
    }


    @GetMapping("/gallery")
    public Response<Object> gallery()
    {
        try {
            return Response.ok().setPayload(universityService.gallery());
        } catch (GalleryNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }

    }
}
