package com.ula.research.feign;

import com.ula.research.domain.model.Image;
import com.ula.research.feign.hystrix.StaticContentServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "ula-static-content-service", fallbackFactory = StaticContentServiceFallbackFactory.class)
public interface StaticContentServiceFeignClient
{
    @PostMapping(value = "/private/image/research", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    String addThumbnailImage
    (
            @RequestHeader(value = "Authorization") String token,
            @RequestPart(value = "file") MultipartFile file
    );

    @PostMapping(value = "/private/image/research/delete")
    String deleteThumbnailImage(@RequestHeader(value = "Authorization") String token, @RequestBody Image image);
}
