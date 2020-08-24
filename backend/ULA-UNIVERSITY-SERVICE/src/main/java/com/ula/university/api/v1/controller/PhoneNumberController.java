package com.ula.university.api.v1.controller;

import com.ula.university.api.v1.request.PhoneNumberRequest;
import com.ula.university.core.annotation.Authorized;
import com.ula.university.core.annotation.Token;
import com.ula.university.core.util.JWT;
import com.ula.university.dto.model.PhoneNumberDTO;
import com.ula.university.dto.response.Response;
import com.ula.university.service.exception.PhoneNumberNotFoundException;
import com.ula.university.service.exception.UniversityInformationNotFoundException;
import com.ula.university.service.phonenumber.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class PhoneNumberController extends BaseController
{

    @Autowired
    private PhoneNumberService phoneNumberService;


    @GetMapping("/contact/phone-number")
    public Response<Object> index()
    {
        return Response.ok().setPayload(phoneNumberService.index());
    }

    @GetMapping("/contact/phone-number/{id}")
    public Response<Object> show(Long id)
    {
        try {
            return Response.ok().setPayload(phoneNumberService.show(id));
        } catch (PhoneNumberNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @PostMapping("/contact/phone-number")
    public Response<Object> store
    (
        @Token JWT jwt,
        @Valid @RequestBody PhoneNumberRequest phoneNumberRequest,
        Errors errors
    )
    {
        try {
            return Response.ok()
                    .setPayload
                        (
                            this.phoneNumberService.store
                                (
                                    new PhoneNumberDTO()
                                            .setContactInfo(this.sanitize(phoneNumberRequest.getContactInfo()))
                                            .setNumber(this.sanitize(phoneNumberRequest.getPhoneNumber()))
                                )

                        );
        } catch (UniversityInformationNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @PutMapping("/contact/phone-number/{id}")
    public Response<Object> update
    (
            @Token JWT jwt,
            @PathVariable("id") Long id,
            @RequestBody @Valid PhoneNumberRequest phoneNumberRequest,
            Errors errors
    )
    {
        try {
            return Response.ok()
                    .setPayload
                        (
                            this.phoneNumberService.update
                                    (
                                        id,
                                        new PhoneNumberDTO()
                                                .setContactInfo(this.sanitize(phoneNumberRequest.getContactInfo()))
                                                .setNumber(this.sanitize(phoneNumberRequest.getPhoneNumber()))
                                    )
                        );
        } catch (PhoneNumberNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @DeleteMapping("/contact/phone-number/{id}")
    public Response<Object> delete
    (
            @Token JWT jwt,
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok()
                    .setPayload(this.phoneNumberService.delete(id));
        } catch (PhoneNumberNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
