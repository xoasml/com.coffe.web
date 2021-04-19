package com.coffe.web.springboot.service.component;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostsComponent {
    public void postsPage(long cnt, List<Long> pages){
        long page = cnt / 10;
        if(cnt % 10 != 0){
            page++;
        }

        for (long i = 1; i <= page; i++) {
            pages.add(i);
        }
    }

}
