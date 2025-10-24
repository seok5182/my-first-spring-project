package com.example.my_first_spring_project;

import lombok.Getter;
import lombok.Setter;

// Lombok을 사용해 Getter, Setter를 자동으로 만듭니다.
// ❗️(중요) Spring이 JSON을 객체로 변환할 때 Setter(또는 생성자)가 필요합니다!
@Getter
@Setter
public class UserDto {
    
    // JSON의 키 이름과 DTO의 필드 이름이 같아야 합니다.
    private String username;
    private int age;

    // (Getter와 Setter는 Lombok이 자동으로 생성해줍니다.)
}