package com.cmuniz.mysecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cmuniz.mysecurity.entities.Role;
import com.cmuniz.mysecurity.entities.User;
import com.cmuniz.mysecurity.repository.RoleRepository;
import com.cmuniz.mysecurity.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired 
    private PasswordEncoder passwordEncoder;
    

    @Override
    public void run(String... args) throws Exception {
        // Cria ROLE_USER se não existir
        if (roleRepository.findByName("ROLE_USER").isEmpty()) {
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
        }

        // Cria ROLE_ADMIN se não existir
        if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }

        if (userRepository.findByUsername("admin").isEmpty()) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("admin"));

            Role userRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseThrow(() -> new RuntimeException("Role não encontrada"));
            user.getRoles().add(userRole);

            userRepository.save(user);
        }

        System.out.println("Roles e Admin inicial criados ou já existentes!");
    }
}