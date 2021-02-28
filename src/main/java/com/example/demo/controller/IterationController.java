package com.example.demo.controller;

import com.example.demo.data.IterationData;
import com.example.demo.service.IterationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IterationController {
    private final IterationService iterationService;

    public IterationController(IterationService iterationService) {
        this.iterationService = iterationService;
    }

    @GetMapping("/result")
    public String show(Model model) {
        model.addAttribute("result", iterationService.show());
        return "result";
    }

    @GetMapping("/create")
    public String home(){
        return "home";
    }

    @PostMapping()
    public String post(IterationData iterationData){
        iterationService.calculation(iterationData);
        return "redirect:/result";
    }

}
