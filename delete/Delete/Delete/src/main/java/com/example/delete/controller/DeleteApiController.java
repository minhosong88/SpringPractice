package com.example.delete.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {
    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account) {
        System.out.println(userId);
        System.out.println(account);

        // delete 는 리소스 삭제이기 때문에, 없는 상태에서 삭제를 해도 에러를 던지지 않고 200을 던지면서 ok 한다.
    }
}
