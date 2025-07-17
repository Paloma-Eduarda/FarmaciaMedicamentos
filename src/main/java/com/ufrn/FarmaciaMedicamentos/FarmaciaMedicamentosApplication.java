package com.ufrn.FarmaciaMedicamentos;

import com.ufrn.FarmaciaMedicamentos.security.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

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
