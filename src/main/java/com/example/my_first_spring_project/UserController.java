package com.example.my_first_spring_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 1. @PathVariable 예제: 특정 ID의 사용자를 조회
     * 요청 URL 예: /users/1
     * 요청 URL 예: /users/42
     */
    @GetMapping("/users/{id}")
    public String getUserById(
            @PathVariable Long id // ⬅️ URL 경로의 {id} 값을 Long 타입으로 받음
    ) {
        // 실제로는 Service를 호출해 id로 사용자를 찾겠죠?
        // return userService.findUserById(id);
        
        return "Path Variable로 요청된 사용자 ID: " + id;
    }

    /**
     * 2. @RequestParam 예제: 특정 조건으로 사용자 목록을 검색
     * 요청 URL 예: /users?role=admin
     * 요청 URL 예: /users?role=guest&page=1
     */
    @GetMapping("/users")
    public String findUsersByRole(
            // "role"이라는 이름의 쿼리 파라미터를 String으로 받음
            // (required = false)는 이 파라미터가 필수가 아님(없어도 됨)을 의미
            @RequestParam(required = false) String role 
    ) {
        if (role != null) {
            // return userService.findUsersByRole(role);
            return "Request Param으로 '" + role + "' 역할을 가진 사용자 목록을 검색합니다.";
        } else {
            // return userService.findAllUsers();
            return "모든 사용자 목록을 조회합니다.";
        }
    }
}
