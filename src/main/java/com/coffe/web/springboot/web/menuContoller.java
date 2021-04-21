package com.coffe.web.springboot.web;

import com.coffe.web.springboot.config.auth.dto.SessionUser;
import com.coffe.web.springboot.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class menuContoller {

    private final PostsService postsService;
    /*
     *  todo 여기는 화면로딩 만들기
     * */

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
