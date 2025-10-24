package com.example.my_first_spring_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getGreeting() {
        return userService.getGreetingMessage(1L);
    }

    @PostMapping("/api/user") // ⬅️ RESTful한 새 경로
    public String createNewUser(
            @RequestBody UserDto userDto // ⬅️ Body의 JSON을 userDto 상자에 담아줘!
    ) {
        // DTO에 데이터가 잘 담겼는지 확인
        System.out.println("받은 이름: " + userDto.getUsername());
        System.out.println("받은 나이: " + userDto.getAge());

        // 받은 데이터를 그대로 응답
        return "이름: " + userDto.getUsername() + ", 나이: " + userDto.getAge() + " | 등록 성공!";
    }
}
