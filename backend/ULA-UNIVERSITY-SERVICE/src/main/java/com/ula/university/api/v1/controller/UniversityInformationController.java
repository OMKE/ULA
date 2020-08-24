package com.ula.university.api.v1.controller;

import com.ula.university.dto.response.Response;
import com.ula.university.service.exception.UniversityInformationNotFoundException;
import com.ula.university.service.universityinformation.UniversityInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UniversityInformationController
{


    @Autowired
    private UniversityInformationService universityInformationService;

    @GetMapping("/information")
    public Response<Object> information()
    {
        try {
            return Response.ok().setPayload(universityInformationService.index());
        } catch (UniversityInformationNotFoundException e)
        {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @GetMapping("/information/about")
    public Response<Object> about()
    {
        try {
            return Response.ok().setPayload(universityInformationService.about());
        } catch (UniversityInformationNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @GetMapping("/information/history")
    public Response<Object> history()
    {
        try {
            return Response.ok().setPayload(universityInformationService.history());
        } catch (UniversityInformationNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @GetMapping("/information/president")
    public Response<Object> president()
    {
        try {
            return Response.ok().setPayload(universityInformationService.president());
        } catch (UniversityInformationNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @GetMapping("/information/teaching-staff")
    public Response<Object> teachingStaff()
    {
        try {
            return Response.ok().setPayload(universityInformationService.teachingStaff());
        } catch (UniversityInformationNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @GetMapping("/information/publishing")
    public Response<Object> publishing()
    {
        try {
            return Response.ok().setPayload(universityInformationService.publishing());
        } catch (UniversityInformationNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
