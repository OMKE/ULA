package com.ula.university.api.v1.controller;

import com.ula.university.api.v1.request.InformationRequest;
import com.ula.university.core.annotation.Authorized;
import com.ula.university.core.annotation.Token;
import com.ula.university.core.util.JWT;
import com.ula.university.dto.response.Response;
import com.ula.university.service.exception.UniversityInformationNotFoundException;
import com.ula.university.service.universityinformation.UniversityInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class UniversityInformationController extends BaseController
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

    @Authorized("ADMIN")
    @PutMapping("/information/about")
    public Response<Object> updateAbout
    (
            @Token JWT jwt,
            @Valid @RequestBody InformationRequest informationRequest,
            Errors errors
    )
    {

        try {
            return Response.ok().setPayload(universityInformationService.updateAbout(this.sanitize(informationRequest.getHtml())));
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

    @Authorized("ADMIN")
    @PutMapping("/information/history")
    public Response<Object> updateHistory
            (
                    @Token JWT jwt,
                    @Valid @RequestBody InformationRequest informationRequest,
                    Errors errors
            )
    {
        try {
            return Response.ok().setPayload(universityInformationService.updateHistory(this.sanitize(informationRequest.getHtml())));
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

    @Authorized("ADMIN")
    @PutMapping("/information/president")
    public Response<Object> updatePresident
            (
                    @Token JWT jwt,
                    @Valid @RequestBody InformationRequest informationRequest,
                    Errors errors
            )
    {
        try {
            return Response.ok().setPayload(universityInformationService.updatePresident(this.sanitize(informationRequest.getHtml())));
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

    @Authorized("ADMIN")
    @PutMapping("/information/teaching-staff")
    public Response<Object> updateTeachingStaff
            (
                    @Token JWT jwt,
                    @Valid @RequestBody InformationRequest informationRequest,
                    Errors errors
            )
    {
        try {
            return Response.ok().setPayload(universityInformationService.updateTeachingStaff(this.sanitize(informationRequest.getHtml())));
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
    @Authorized("ADMIN")
    @PutMapping("/information/publishing")
    public Response<Object> updatePublishing
            (
                    @Token JWT jwt,
                    @Valid @RequestBody InformationRequest informationRequest,
                    Errors errors
            )
    {
        try {
            return Response.ok().setPayload(universityInformationService.updatePublishing(this.sanitize(informationRequest.getHtml())));
        } catch (UniversityInformationNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
