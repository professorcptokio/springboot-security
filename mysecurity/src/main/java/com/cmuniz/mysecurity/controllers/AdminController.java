package com.cmuniz.mysecurity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cmuniz.mysecurity.entities.User;
import com.cmuniz.mysecurity.service.UserService;



@Controller
public class AdminController {
    

     @Autowired private UserService userService;

    @GetMapping("/admin")
    public String listUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
       return "admin"; 
    }
    
}
