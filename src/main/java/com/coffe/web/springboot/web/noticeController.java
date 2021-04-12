package com.coffe.web.springboot.web;

import com.coffe.web.springboot.service.PostsService;
import com.coffe.web.springboot.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

public class noticeController {
    /*
     *  todo 상세보기 기능은 여기에 만들고
     * */

    @GetMapping("/noticeDetails")
    public String noticeDetails(){
        return "notice";
    }

}
