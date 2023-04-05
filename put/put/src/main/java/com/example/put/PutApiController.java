package com.example.put;

import com.example.put.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {
    @PutMapping("/put/{userId}") //중괄호 안의 값은 PathVariable 에 대응하는 변수과 같아야한다.
                                //변수에 다른 값을 쓰는 경우 PathVariable(name = userId)처럼 지정해줘야 함.
    public PutRequestDto put(@RequestBody PutRequestDto requestDto, @PathVariable(name = "userId") long id){
        System.out.println(id);
        return requestDto;
    }
}
//'Response' 는 @RestController 의 경우에는 object 를 return 해주면 된다.