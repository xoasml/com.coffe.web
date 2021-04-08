package com.coffe.web.springboot.web.dto;

import com.coffe.web.springboot.domain.posts.Posts;
import lombok.Getter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = LocalDateTime.now(); // 나중에 고쳐야됨★

    }
}
