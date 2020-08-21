package com.ula.faculty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UlaFacultyServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(UlaFacultyServiceApplication.class, args);
    }

}
