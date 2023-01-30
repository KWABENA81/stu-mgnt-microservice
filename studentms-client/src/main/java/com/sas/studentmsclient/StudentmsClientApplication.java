package com.sas.studentmsclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableHystrix
public class StudentmsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentmsClientApplication.class, args);
    }

}
