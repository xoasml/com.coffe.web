package com.coffe.web.springboot.service;

import com.coffe.web.springboot.domain.posts.Posts;
import com.coffe.web.springboot.domain.posts.PostsRepository;
import com.coffe.web.springboot.service.component.PostsComponent;
import com.coffe.web.springboot.web.dto.PostsListResponseDto;
import com.coffe.web.springboot.web.dto.PostsResponseDto;
import com.coffe.web.springboot.web.dto.PostsSaveRequestDto;
import com.coffe.web.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor // (롬복)
@Service // 나 서비스에요! (롬복)
public class PostsService {

    private final PostsRepository postsRepository;
    private final PostsComponent postsComponent;

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
    public List<PostsListResponseDto> firstPageSelector() {
        return postsRepository.firstPageSelector().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Long> count() {
        List<Long> pages = new ArrayList<>();
       postsComponent.postsPage(postsRepository.count(),pages);
        return pages;
    }

    @Transactional
    public void delete (Long id) { //Warrper 클래스를 사용하는 이유는 만약에 해당 값이 없으면 null이 들어가야 하는데 원시타입(long)은 0이 들어가므로 데이터에 0이 들어있게 된다.
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

}
