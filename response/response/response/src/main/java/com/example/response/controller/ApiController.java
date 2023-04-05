package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class ApiController {
    //Text
    @GetMapping("/text")
    public String text(@RequestParam String account) {

        return account;
    }

    //Json
    @PostMapping("/json")
    //request -> objectMapper -> object -> method -> object -> objectMapper -> json -> response
    public User json(@RequestBody User user) {
        return user;
    }

    //ResponseEntity 사용
    @PutMapping("/put") //응답에 대해서 customizing 하려면 이 방법을 사용하자. 명확하게.
    public ResponseEntity<User> put(@RequestBody User user) {
       return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }


}
