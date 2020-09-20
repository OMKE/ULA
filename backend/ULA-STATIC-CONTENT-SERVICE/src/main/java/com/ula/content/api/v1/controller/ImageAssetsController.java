package com.ula.content.api.v1.controller;

import com.ula.content.service.exception.ImageNotFoundException;
import com.ula.content.service.file.FileService;
import com.ula.content.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ImageAssetsController
{

    @Autowired
    private ImageService imageService;

    @Autowired
    private FileService fileService;


    @GetMapping(value = "/assets/image/{imageName:.+}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] show(@PathVariable("imageName") String imageName)
    {
        try {
            return imageService.load("assets" + fileService.separator() + "img", imageName);
        } catch (ImageNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }
}
