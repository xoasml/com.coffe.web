package com.coffe.web.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // lombok : Getter 메소드 자동 생성
@NoArgsConstructor // lombok : 생성자 자동 생성
@Entity // 테이블과 링크될 클래스임을 명시 해주는 어노테이션
public class Posts {
    @Id // 해당 테이블의 PK필드임을 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk의 생성 규칙을 나타냄
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼을 나타냄, 기본값 외에 추가로 변경이 필요할때 사용 ex VARCHAR(255) 사이즈 500 으로 늘리고 싶다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private  String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
