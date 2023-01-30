package com.sas.studentms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
public class StudentMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentMsApplication.class, args);
    }

}
