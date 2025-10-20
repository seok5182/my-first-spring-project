package com.example.my_first_spring_project;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public String findUserNameById(Long id) {
        if (id == 1L) {
            return "Gemini";
        }
        return null;
    };
}
