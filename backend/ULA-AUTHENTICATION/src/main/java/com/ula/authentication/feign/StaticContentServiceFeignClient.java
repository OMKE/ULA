package com.ula.authentication.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.ula.core.api.response.Response;

@FeignClient(value = "ula-static-content-service")
public interface StaticContentServiceFeignClient
{
    @PostMapping(value = "image/users", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Object> addProfileImage
    (
            @RequestHeader(value = "Authorization", required = true) String token,
            @RequestPart(value = "file") MultipartFile file
    );

    @DeleteMapping("image/users/{username}")
    Response<Object> deleteProfileImage
    (
        @RequestHeader(value = "Authorization", required = true) String token,
        @PathVariable("username") String username,
        @RequestBody Response response
    );





}
