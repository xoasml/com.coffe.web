package com.coffe.web.springboot.web;

import com.coffe.web.springboot.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor
@Controller
public class menuContoller {

    private final PostsService postsService;

    @GetMapping("/notice")
    public String notice(Model model){
        model.addAttribute("postsPage",postsService.count());
        model.addAttribute("posts", postsService.firstPageSelector());

        return "notice";
    }

    @GetMapping("/qna")
    public String qna(Model model){
        model.addAttribute("postsPage",postsService.count());
        model.addAttribute("posts", postsService.firstPageSelector());

        return "qna";
    }
}
