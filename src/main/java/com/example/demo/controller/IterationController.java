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

    @GetMapping("/result_iter")
    public String show(Model model) {
        model.addAttribute("result", iterationService.show());
        return "result";
    }

    @GetMapping("/iter_method")
    public String iteration(){
        return "iteration_method";
    }

    @PostMapping()
    public String post(IterationData iterationData){
        iterationService.calculation(iterationData);
        return "redirect:/result_iter";
    }

}
