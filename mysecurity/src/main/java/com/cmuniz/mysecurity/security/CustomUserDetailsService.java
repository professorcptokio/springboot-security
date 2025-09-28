package com.cmuniz.mysecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.cmuniz.mysecurity.entities.User;
import com.cmuniz.mysecurity.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    @Autowired private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        logger.info("Tentando autenticar usuário: {}", username);
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> {
                logger.warn("Usuário não encontrado: {}", username);
                return new UsernameNotFoundException("Usuário não encontrado");
            });

        logger.info("Usuário encontrado: {} ({} roles)", user.getUsername(), user.getRoles().size());
        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList()
        );
    }
}