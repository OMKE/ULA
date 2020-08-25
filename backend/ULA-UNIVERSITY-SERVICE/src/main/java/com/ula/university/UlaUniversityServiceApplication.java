package com.ula.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableEurekaClient
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.COLLECTION_JSON)
@EnableFeignClients(basePackages = {"org.ula.core.feign", "com.ula.university.feign"})
@EnableCircuitBreaker
@ComponentScan({"com.ula.university","org.ula.core"})
@SpringBootApplication
public class UlaUniversityServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(UlaUniversityServiceApplication.class, args);
    }

}
