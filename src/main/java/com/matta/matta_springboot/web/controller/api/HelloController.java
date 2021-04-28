package com.matta.matta_springboot.web.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello(){
        return "안녕 helloController " + new Date() + "테스트입니다";
    }
}
