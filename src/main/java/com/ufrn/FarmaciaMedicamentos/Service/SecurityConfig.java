package com.ufrn.FarmaciaMedicamentos.Service;


import com.ufrn.FarmaciaMedicamentos.Repository.SecurityUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class SecurityConfig implements UserDetailsService {

    private final SecurityUserRepository securityUserRopository;

    public SecurityConfig(SecurityUserRepository securityUserRopository) {
        this.securityUserRopository = securityUserRopository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("🔐 Buscando usuário no sistema: {}"+ username);
        return securityUserRopository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
    }
}

