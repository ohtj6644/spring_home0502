package com.ll.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainConctroller {
    @GetMapping("/sbb")
    @ResponseBody
    public String sbb(){
        return "index";
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/question/list";
        // 퀘스쳔/리스트 로 리다이렉트 하는 명령어
    }
}
