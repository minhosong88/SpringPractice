package com.example.Hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //해당 클래스는 restAPI를 처리하는  Controller'
@RequestMapping("/api") // RequestMapping  URI를 지정해주는 Annotation

public class ApiController {

    @GetMapping("/hello") //http://localhost:8080/api/hello 라는 주소가 맵핑 된 것이다.
    public String hello(){
        return "Hello, Spring boot!";
    }

}
