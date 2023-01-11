package com.example.hrmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HrManagerApplication {

    public static void main(String[] args) {
        try
        {
            SpringApplication.run(HrManagerApplication.class, args);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
