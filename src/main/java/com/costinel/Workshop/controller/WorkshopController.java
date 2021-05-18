package com.costinel.Workshop.controller;

import com.costinel.Workshop.service.GenericWelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WorkshopController {

    @Autowired
    private GenericWelcomeService workshopService;

    @RequestMapping
    public String home(Model model){

        List<String> welcomeMessage = workshopService.getWelcomeMessage("Costinel Negura");
        model.addAttribute("myList", welcomeMessage);
        return "home";
    }


}
