package org.curd.controller;

import org.curd.dto.LunYuDto;
import org.curd.services.LunYuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/lunyu")
@Controller
public class LunYuController {

    @Autowired
    private LunYuService service;

    @RequestMapping("/page/{page}")
    public String page(Model model, @PathVariable(name = "page") Integer page){

        List<LunYuDto> lunYuDtos =  service.findByPage(page,10);
        contentReplace(lunYuDtos);
        model.addAttribute("items",lunYuDtos);
        return "list-lunyu";
    }

    @RequestMapping("/rand/{page}")
    public String rand(Model model, @PathVariable(name = "page") Integer page){
        List<LunYuDto> lunYuDto = service.findRandPage(page);
        contentReplace(lunYuDto);
        model.addAttribute("items",lunYuDto);
        return "list-lunyu";
    }

    private void contentReplace(List<LunYuDto> src){
        for (LunYuDto LunYu : src) {
            LunYu.setContent(LunYu.getContent().replace("|","<br><br>"));
        }
    }
}
