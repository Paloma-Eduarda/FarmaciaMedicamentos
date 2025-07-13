//package com.ufrn.FarmaciaMedicamentos.Service;
//
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import ufrn.br.aularest2025.repository.SecurityUserRepository;
//
//public class SecurityConfig {
//
//    private final SecurityUserService userService;
//
//    public SecurityConfig(SecurityUserService userService) {
//        this.userService = userService;
//    }
//
//
//    @Override
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.info("🔐 Buscando usuário no sistema: {}", username);
//        return repository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
//    }
//}
//
//}