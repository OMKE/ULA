package com.ula.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UlaAuthenticationApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(UlaAuthenticationApplication.class, args);
    }

}
