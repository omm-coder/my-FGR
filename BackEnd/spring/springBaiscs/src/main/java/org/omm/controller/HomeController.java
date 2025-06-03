package org.omm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {


    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("msg","SCHOOL MANAGEMENT SYSTEM");
        return "homePage";
    }

    @GetMapping("/welcome")
    public String welcomePage(Model model) {
        model.addAttribute("msg","SCHOOL MANAGEMENT SYSTEM");
        return "welcomePage";
    }




}
