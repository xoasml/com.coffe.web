package com.coffe.web.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class menuContoller {

    @GetMapping("/notice")
    public String notice(){
        return "notice";
    }
}