package com.ula.research.feign.hystrix;

import com.ula.research.domain.model.Image;
import com.ula.research.feign.StaticContentServiceFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class StaticContentServiceFallbackFactory implements FallbackFactory<StaticContentServiceFeignClient>
{

    private static final Logger LOGGER = LoggerFactory.getLogger(StaticContentServiceFallbackFactory.class);

    @Override
    public StaticContentServiceFeignClient create(Throwable cause)
    {
        return new StaticContentServiceFeignClient()
        {
            @Override
            public String addThumbnailImage(String token, MultipartFile file)
            {
                LOGGER.error("Error occurred while storing image in static content service", cause);
                return null;
            }

            @Override
            public String deleteThumbnailImage(String token, Image image)
            {
                LOGGER.error("Error occurred while deleting image in static content service", cause);
                return "research/no-thumbnail.png";
            }
        };
    }
}
