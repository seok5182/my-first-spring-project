package com.example.my_first_spring_project;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getGreetingMessage(Long id) {
        String userName = userRepository.findUserNameById(id);

        if (userName != null) {
            return "안녕하세요, " + userName + "님!";
        } else {
            return "사용자를 찾을 수 없습니다.";
        }
    }
}
