package com.example.post.controller;

import com.example.post.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")

public class PostApiController {
    @PostMapping("/post")
    //public void post(@RequestBody Map<String, Object> requestData){
    //        requestData.forEach((key, value) -> {
    //            System.out.println("key: " + key);
    //            System.out.println("value: " + value);
    //        });
    //    } //하나하나 값을 쓰기에 무리가 있으므로 클라이언트가 직접 작성하면 받아오는 방식으로 dto 사용한다.
    //
    public void post(@RequestBody PostRequestDto requestData) { //Post로 들어오는 데이터를 매핑하려면
        System.out.println(requestData);                //@RequestBody annotation이 필요하다.
        };
    }

