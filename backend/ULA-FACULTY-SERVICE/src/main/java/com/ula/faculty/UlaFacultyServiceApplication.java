package com.ula.faculty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableEurekaClient
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.COLLECTION_JSON)
@EnableFeignClients
@EnableCircuitBreaker
@ComponentScan({"com.ula.faculty","org.ula.core"})
@SpringBootApplication
public class UlaFacultyServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(UlaFacultyServiceApplication.class, args);
    }

}
