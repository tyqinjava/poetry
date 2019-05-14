package org.curd.controller;


import org.curd.dto.PoemsDto;
import org.curd.services.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/poems")
public class PoemsController {


    @Autowired
    private PoemService service;

    @RequestMapping("/page/{page}")
    public String page(Model model, @PathVariable(name = "page") Integer page){

        List<PoemsDto> poemsDtos =  service.findByPage(page,10);
        replace(poemsDtos);
        model.addAttribute("items",poemsDtos);
        return "list";
    }

    @RequestMapping("/rand/{page}")
    public String rand(Model model, @PathVariable(name = "page") Integer page){
        List<PoemsDto> poemsDtos = service.findRandPage(page);
        replace(poemsDtos);
        model.addAttribute("items",poemsDtos);
        return "list";
    }

    private void replace(List<PoemsDto> src){
        for (PoemsDto poemsDto : src) {
            poemsDto.setContent(poemsDto.getContent().replace("|","<br><br>"));
        }
    }
}
