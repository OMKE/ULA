package com.ula.university.api.v1.controller;


import com.ula.university.service.contact.ContactService;
import com.ula.university.service.exception.LocationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.api.response.Response;

@RestController
public class ContactController
{

    @Autowired
    private ContactService contactService;


    @GetMapping("/contact")
    public Response<Object> index()
    {
        try {
            return Response.ok().setPayload(this.contactService.index());
        } catch (LocationNotFoundException e)
        {
            return Response.exception().setErrors(e.getMessage());
        }
    }


}
