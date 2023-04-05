package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";

    }

    //ResponseEntity    잘 사용하지 않는 방법이다.
    //String 을 사용하면 Resource 를 찾지만 ResponseBody 를 사용하면 객체를 리턴할 때 ResponseBody 를 만들겠다는 뜻.
 /*   @ResponseBody //
    @GetMapping("/user")
    public User user() {
        var user = new User(); //var를 사용하면 나중에 클래스가 아주 길어서 타이핑 하기 싫을 때 좋다.
        user.setName("Steve");
        user.setAddress("FastCampus");
        return user;
    }
*/

}
