package org.omm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.PublicKey;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("message","Display the image.");
        return "home";
    }

    @GetMapping("/index")
    public String indexPage(Model model) {
        model.addAttribute("name",model.getAttribute("name"));
        System.out.println("name: form flash: "+ model.getAttribute("name"));
        return "index";
    }

    @PostMapping("/send")
    public String send(@RequestParam("name") String name,
                       RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("name", name);
        System.out.println("name: "+ name);
        return "redirect:/index";
    }
}
