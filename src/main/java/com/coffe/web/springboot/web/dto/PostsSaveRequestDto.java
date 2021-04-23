package com.coffe.web.springboot.web.dto;

import com.coffe.web.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String board;
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String board, String title, String content, String author) {
        this.board = board;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .postKind(board)
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
