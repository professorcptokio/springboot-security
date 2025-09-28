package com.cmuniz.mysecurity.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cmuniz.mysecurity.dto.UserRegistrationDto;
import com.cmuniz.mysecurity.service.UserService;


@Controller
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    @Autowired private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        logger.info("Exibindo formulário de registro");
        model.addAttribute("user", new UserRegistrationDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserRegistrationDto dto) {
        logger.info("Recebendo registro de usuário: {}", dto.getUsername());
        userService.registerNewUser(dto);
        logger.info("Usuário registrado com sucesso: {}", dto.getUsername());
        return "redirect:/login";
    }
}