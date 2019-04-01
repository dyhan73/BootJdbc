package com.skplanet.dxp.HelloBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloBootApplication {

    @RequestMapping("/")
    String home() {
        return "Hello Boot!!";
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloBootApplication.class, args);
    }

}
