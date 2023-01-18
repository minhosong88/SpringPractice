package com.example.Hello.controller;

import com.example.Hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get/")
public class GetApiController {
    //<get 메서드를 지정하는 방법>
    //getMapping에 path를 (경로를) 명확하게 표시하는 방법도 있고
    @GetMapping(path = "/hello") // http://localhost:8080/api/get/hello
    public String Hello() {
        return "get Hello";

    }
/*  이건 예전에 사용하던 방식이므로 위에 것만 배우자
    // RequestMapping 사용시 path와 method 비 지정시 get / post / put / delete 모두에 작동하게 되므로 주의.
    @RequestMapping(path = "/hi", method = RequestMethod.GET) // method = 후에 ctrl+space를 누르면 자동완성
    public String hi() {
        return "hi";
    }*/

//--------------------------------------------------------------------------------------
    //<PathVariable 받는 법>

    // 주소에는 대문자 안 쓰므로 '-'를 쓰면 가독성 향상
    //http://localhost:8080/api/get/path-variable/{name}  {}안의 값이 계속 변할 것이다.
/*
    @GetMapping("/path-variable/{name}") //** {} 안에 쓴 내용와 변수에 사용한 내용이 같아야 한다. ex) name
    public String pathVariable(@PathVariable String name) {
        //변수를 @PathVariable annotation을 쓴 후에 가져온다.
        System.out.println("PathVariable: " + name); //변수를 받아서 콘솔에 찍고

        return name; //그 변수를 반환 받는다.
    }
*/

    // 변수 이름과 {}안의 이름이 달라져야하는 경우, @PathVariable(name = "")으로 맞춰주면 된다.
    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id") String pathName) {
        System.out.println("PathVariable: " + pathName);
        return pathName;
    }
    //---------------------------------------------------------------------------------
    //<Query Parameter 받는 법>  query parameter? : 검색할 때 주로 사용된다.
    // ?key=value&key2=value2&key3=value3 형태로 사용.

    //주소 설계하기: http://localhost:8080/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")  // data 형태가 key=value니까 map으로 할 수 있겠구나.
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        //Map 자체를 return하면 값이 없다. 그래서 StringBuffer에 담아서 toString으로 반환할 수 있다.
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + "=" + entry.getValue() + "\n");
        });
        return sb.toString();
    }
    //---------------------------------------------------------------------------------------
    //Query Parameter에 어떤 항목이 들어갈 수 있는지 명확하게 제시한 경우

    @GetMapping(path = "query-param02")
    public String queryParameter(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
        ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name+" "+email+" "+age;
    }

    //------------------------------------------------------------------------------------------
    //QueryParameter가 많아지면 @RequestParam 계속 붙이기 힘들기 때문에
    // //새 패키지를 만들고 클래스를 지정해서 dto를 사용한다. <추천방식>
    @GetMapping(path = "query-param03")
    public String queryParamet(UserRequest userRequest) { //@RequestParam 붙이지 않는다,

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }
}
