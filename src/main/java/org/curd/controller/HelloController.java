package org.curd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String home(){
        return "hello world";
    }

    @RequestMapping("/success")
    public String success(Model model){
        model.addAttribute("hello","你好！");
        return "success";
    }


}
