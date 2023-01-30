package com.sas.studentmsclient.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sas.studentmsclient.model.StudentClient;
import com.sas.studentmsclient.service.StudentClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/stu-client")
public class StudentClientResource {

//    @Autowired
//    private StudentClientService studentClientService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/student-client/{id}")
    @HystrixCommand(fallbackMethod = "fallbackMethod",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
            })
    public Object getStudentsFGromStudentms(@PathVariable String id) {
        log.info("About to call studentms");
        return restTemplate.getForObject("http://studentms/students/" + id, Object.class);
    }

    private Object fallbackMethod(String id) {
        return Arrays.asList("S", "T", "C", "K");
    }

//    @PostMapping("/handleStudent")
//    public StudentClient handleStudent(@RequestBody StudentClient studentClient){
//        return studentClientService.handleStudent(studentClient);
//    }
}
