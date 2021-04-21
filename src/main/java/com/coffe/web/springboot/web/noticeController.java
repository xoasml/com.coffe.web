package com.coffe.web.springboot.web;


import com.coffe.web.springboot.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class noticeController {

    private final PostsService postsService;

    @GetMapping("/noticeDetails")
    public String noticeDetails(){
        return "notice";
    }

    @GetMapping("/notice/{page}")
    public String notice(@PathVariable Long page, Model model){
        model.addAttribute("postsPage", postsService.count());
        model.addAttribute("posts", postsService.pageSelector(page));

        return "notice";
    }


}
