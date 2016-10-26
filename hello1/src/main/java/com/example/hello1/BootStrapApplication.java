package com.example.hello1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class BootStrapApplication {

    @Autowired
    private Hello2Client hello2Client;

    public static void main(String[] args) {
        SpringApplication.run(BootStrapApplication.class, args);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String hello1() {
        return "-> Hello World 1 " + hello2Client.hello2();
    }
}
