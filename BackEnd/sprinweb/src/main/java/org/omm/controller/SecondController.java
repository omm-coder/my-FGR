package org.omm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SecondController {

    @GetMapping("/user")
    public String userPage() {

        return "userPage";
    }

    @GetMapping("/admin")
    public String userInfo() {

        return "adminPage";
    }


}
