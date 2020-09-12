package com.ula.content.api.v1.controller;

import com.ula.content.service.exception.FileStorageException;
import com.ula.content.service.exception.IllegalTypeOfFileException;
import com.ula.content.service.exception.ImageNotFoundException;
import com.ula.content.service.image.ImageService;
import feign.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;
import org.ula.core.exception.NotAuthorizedException;
import org.ula.core.util.JWTUtil;

@RestController
public class UserImageController
{

    @Autowired
    private ImageService imageService;

    @Autowired
    private JWTUtil jwtUtil;


//    https://spring.io/guides/gs/uploading-files/
    @GetMapping(value = "/image/users/{imageName:.+}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] show(@PathVariable("imageName") String imageName)
    {
        try {
            return imageService.load("users", imageName);
        } catch (ImageNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @Authorized("USER")
    @PostMapping(value = "/image/users")
    @Headers("Content-Type: multipart/form-data")
    public Response<Object> store
    (
            @RequestPart(value = "file") MultipartFile file

    )
    {
        try {
            return Response.ok().setPayload(this.imageService.store(file, "users"));
        } catch (FileStorageException | IllegalTypeOfFileException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("USER")
    @DeleteMapping("/image/users/{username}")
    public Response<Object> delete
    (
        @PathVariable("username") String username,
        @RequestBody Response request
    )
    {
        try {
            if(jwtUtil.getUsername().equals(username))
            {
                return Response.ok().setPayload(this.imageService.delete((String) request.getPayload()));
            } else {
                throw new NotAuthorizedException("You're not authorized for that action");
            }

        } catch (FileStorageException | NotAuthorizedException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

}
