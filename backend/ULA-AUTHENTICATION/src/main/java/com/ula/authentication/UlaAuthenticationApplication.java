package com.ula.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@ComponentScan({"com.ula.authentication","org.ula.core"})
public class UlaAuthenticationApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(UlaAuthenticationApplication.class, args);
    }

}
