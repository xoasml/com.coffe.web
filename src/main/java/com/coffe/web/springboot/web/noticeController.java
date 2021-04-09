package com.coffe.web.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class noticeController {
    /*
     *  todo 상세보기 기능은 여기에 만들고
     * */
    @GetMapping("/noticeDetails")
    public String noticeDetails(){
        return "notice";
    }
}
