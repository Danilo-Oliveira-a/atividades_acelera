package br.atos.zoologico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ZoologicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZoologicoApplication.class, args);

		System.out.print("SENHA: "+new BCryptPasswordEncoder().encode("123"));
	}


}
