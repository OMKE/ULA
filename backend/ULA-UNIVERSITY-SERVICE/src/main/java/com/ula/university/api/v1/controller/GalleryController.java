package com.ula.university.api.v1.controller;


import com.ula.university.service.exception.GalleryNotFoundException;
import com.ula.university.service.gallery.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.api.response.Response;

@RestController
public class GalleryController
{
    @Autowired
    private GalleryService galleryService;



    @GetMapping("/gallery")
    public Response<Object> index()
    {
        try {
            return Response.ok().setPayload(this.galleryService.index());
        } catch (GalleryNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

}
