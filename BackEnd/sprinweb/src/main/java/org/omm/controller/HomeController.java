package org.omm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {



    @Autowired
    private InMemoryUserDetailsManager memoryUserDetailsManager;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/userLogin")
    public String userLogin() {
        return "userLogin";
    }

//    @PostMapping("/processLogin")
//    public String processLogin(@RequestParam("userName")String userName,
//                               @RequestParam("pass") String pass) {
////        UserDetails user = userDetailsService.loadUserByUsername(userName);
////        if (user == null)
////            throw new UsernameNotFoundException("UserNotFund!!!!!");
////        System.out.println("getting printing the authentication object");
////        System.out.println("username: "+user.getAuthorities());
////        System.out.println("UserRoles: "+user.getAuthorities());
//        System.out.println("Inside authentication method");
//        System.out.println("UserName: "+ userName);
//
//        return "redirect:/";
//    }




    @GetMapping("/register")
    public String userRegistration() {

        return "userRegistration";
    }
    @PostMapping("/save")
    public String saveUser(@RequestParam("userName") String userName,
                           @RequestParam("pass") String pass) {
        UserDetails user = User.withUsername(userName)
                .password("{noop}"+pass)
                .roles("USER")
                .build();
        memoryUserDetailsManager.createUser(user);
        return "redirect:/";
    }
}
