package com.example.my_first_spring_project;

// JPA 엔티티 관련 어노테이션들을 임포트합니다.
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter; // Lombok을 사용해 Getter를 만듭니다.
import lombok.Setter;  // Lombok을 사용해 Setter를 만듭니다.

@Getter
@Setter
@Entity // 1. "이 클래스는 DB 테이블과 매핑되는 엔티티입니다!"
public class User {

    @Id // 2. "이 필드가 바로 Primary Key(고유 식별자)입니다!"
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3. "이 값은 MySQL이 알아서 자동 생성(auto-increment)합니다!"
    private Long id; // 사용자 고유 ID

    // (참고) @Column 어노테이션으로 컬럼 세부 설정을 할 수 있습니다.
    // name="user_name" : DB 테이블에는 user_name이라는 컬럼 이름으로 저장
    // nullable=false : 이 값은 비어있을 수 없음 (NOT NULL)
    // @Column(name = "user_name", nullable = false) 
    private String username; // 사용자 이름

    private String email; // 사용자 이메일

    // (Getter/Setter 등은 Lombok이 자동으로 만들어줍니다)
}