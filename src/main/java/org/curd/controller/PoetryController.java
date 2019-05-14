package org.curd.controller;

import org.curd.dto.PoetryDto;
import org.curd.services.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



@Controller
@RequestMapping("/poetry")
public class PoetryController {


    @Autowired
    private PoetryService service;

    @RequestMapping("/page/{page}")
    public String page(Model model, @PathVariable(name = "page") Integer page){

        List<PoetryDto> poetryDtos =  service.findByPage(page,10);
        contentReplace(poetryDtos);
        model.addAttribute("items",poetryDtos);
        return "list";
    }

    @RequestMapping("/rand/{page}")
    public String rand(Model model, @PathVariable(name = "page") Integer page){
        List<PoetryDto> poetryDto = service.findRandPage(page);
        contentReplace(poetryDto);
        model.addAttribute("items",poetryDto);
        return "list";
    }

    private void contentReplace(List<PoetryDto> src){
        for (PoetryDto poetry : src) {
            poetry.setContent(poetry.getContent().replace("|","<br><br>"));
        }
    }
}
