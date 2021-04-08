package com.coffe.web.springboot.service;

import com.coffe.web.springboot.domain.posts.Posts;
import com.coffe.web.springboot.domain.posts.PostsRepository;
import com.coffe.web.springboot.web.dto.PostsListResponseDto;
import com.coffe.web.springboot.web.dto.PostsResponseDto;
import com.coffe.web.springboot.web.dto.PostsSaveRequestDto;
import com.coffe.web.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor // (롬복)
@Service // 나 서비스에요! (롬복)
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto reqeuestDto){
        return postsRepository.save(reqeuestDto.toEntity()).getId();
    }

    @Transactional // 구글링해서 의미에대해 한번 잘 읽어보기
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
