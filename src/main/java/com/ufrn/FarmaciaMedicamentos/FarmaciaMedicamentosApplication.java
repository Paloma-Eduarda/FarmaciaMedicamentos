package com.ufrn.FarmaciaMedicamentos;

import com.ufrn.FarmaciaMedicamentos.Repository.SecurityUserRepository;
import com.ufrn.FarmaciaMedicamentos.domain.Pessoa;
import com.ufrn.FarmaciaMedicamentos.domain.SecurityUser;
import com.ufrn.FarmaciaMedicamentos.security.RsaKeyProperties;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class FarmaciaMedicamentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmaciaMedicamentosApplication.class, args);
	}

//	@Autowired
//	SecurityUserRepository securityUserRerpository;
//
//	@Autowired
//	BCryptPasswordEncoder encoder;
//
//
//	@PostConstruct
//	public void started() {
//		Pessoa p = new Pessoa("João", 20, true);
//
//		SecurityUser securityUser = new SecurityUser();
//		securityUser.setPessoa(p);
//		securityUser.setUsername("admin");
//		securityUser.setPassword(encoder.encode("admin"));
//
//		securityUserRerpository.save(securityUser);
//	}
}
