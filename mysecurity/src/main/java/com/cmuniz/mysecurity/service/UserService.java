package com.cmuniz.mysecurity.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cmuniz.mysecurity.dto.UserRegistrationDto;
import com.cmuniz.mysecurity.entities.Role;
import com.cmuniz.mysecurity.entities.User;
import com.cmuniz.mysecurity.repository.RoleRepository;
import com.cmuniz.mysecurity.repository.UserRepository;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    public User registerNewUser(UserRegistrationDto dto) {
        logger.info("Registrando novo usuário: {}", dto.getUsername());
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        Role userRole = roleRepository.findByName("ROLE_USER")
            .orElseThrow(() -> new RuntimeException("Role não encontrada"));
        user.getRoles().add(userRole);

        User saved = userRepository.save(user);
        logger.info("Usuário salvo com id: {}", saved.getId());
        return saved;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}