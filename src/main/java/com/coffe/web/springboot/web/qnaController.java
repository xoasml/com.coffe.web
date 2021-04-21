package com.coffe.web.springboot.web;

import com.coffe.web.springboot.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class qnaController {

    private final PostsService postsService;

    @GetMapping("/qnaDetails")
    public String qnaDetails(){ return "qna"; }

    @GetMapping("/qna/{page}")
    public String qna(@PathVariable Long page, Model model){
        model.addAttribute("postsPage", postsService.count());
        model.addAttribute("posts",postsService.pageSelector(page));

        return "qna";
    }
}
