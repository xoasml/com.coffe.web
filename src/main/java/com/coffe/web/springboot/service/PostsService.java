package com.coffe.web.springboot.service;

import com.coffe.web.springboot.domain.posts.Posts;
import com.coffe.web.springboot.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service // 나 서비스에요!
public class PostsService {

    private final PostsRepository postsRepository;

    public List<Posts> hello(){
        List<Posts> findAll = postsRepository.findAll();
        return findAll;
    }

}
