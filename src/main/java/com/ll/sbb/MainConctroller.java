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
}
