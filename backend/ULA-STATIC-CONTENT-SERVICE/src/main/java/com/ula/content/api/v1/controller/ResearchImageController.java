package com.ula.content.api.v1.controller;

import com.ula.content.domain.Image;
import com.ula.content.service.exception.FileStorageException;
import com.ula.content.service.exception.IllegalTypeOfFileException;
import com.ula.content.service.image.ImageService;
import feign.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.ula.core.annotation.Authorized;

@RestController
public class ResearchImageController
{

    @Autowired
    private ImageService imageService;

    @Authorized("CONTENT_CREATOR")
    @PostMapping("/private/image/research")
    @Headers("Content-Type: multipart/form-data")
    public String store
    (
            @RequestPart(value = "file") MultipartFile file
    )
    {
        try {
            return this.imageService.store(file, "research");
        } catch (FileStorageException | IllegalTypeOfFileException e) {
            return null;
        }
    }

    @Authorized("CONTENT_CREATOR")
    @PostMapping(value = "/private/image/research/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String delete
    (
        @RequestBody Image image
    )
    {
        try {
            return this.imageService.delete(image.getPath());
        } catch (FileStorageException e) {
            return null;
        }
    }

}
