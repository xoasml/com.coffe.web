package com.coffe.web.springboot.web;

import com.coffe.web.springboot.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController // 나 컨트롤러에요!
public class PostsApiController {

    private final PostsService postsService;

    @GetMapping("/hello")
    public String hello(){
        System.out.println(postsService.hello());
        return "Hello";
    }

}


