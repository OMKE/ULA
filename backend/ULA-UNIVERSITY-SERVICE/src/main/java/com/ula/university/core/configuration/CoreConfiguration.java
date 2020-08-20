package com.ula.university.core.configuration;

import com.ula.university.core.resolver.TokenResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Configuration
@EnableWebMvc
public class CoreConfiguration implements WebMvcConfigurer
{

    /*
        Registering our TokenResolver Bean so Spring can use it
    */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers)
    {
        resolvers.add(new TokenResolver());
    }


    /*
        Somehow if we don't set the default return type, it sets xml as default which we don't want in any case
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer)
    {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }
}
