package org.curd.controller;


import org.curd.dto.ShiJingDto;
import org.curd.services.ShiJingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/shijing")
@Controller
public class ShijingController {


    @Autowired
    private ShiJingService service;

    @RequestMapping("/page/{page}")
    public String page(Model model, @PathVariable(name = "page") Integer page){

        List<ShiJingDto> shiJingDtos =  service.findByPage(page,10);
        replace(shiJingDtos);
        model.addAttribute("items",shiJingDtos);
        return "list-shijing";
    }

    @RequestMapping("/rand/{page}")
    public String rand(Model model, @PathVariable(name = "page") Integer page){
        List<ShiJingDto> shiJingDto = service.findRandPage(page);
        replace(shiJingDto);
        model.addAttribute("items",shiJingDto);
        return "list-shijing";
    }

    private void replace(List<ShiJingDto> src){
        for (ShiJingDto shiJing : src) {
            shiJing.setContent(shiJing.getContent().replace("|","<br><br>"));
        }
    }
}
