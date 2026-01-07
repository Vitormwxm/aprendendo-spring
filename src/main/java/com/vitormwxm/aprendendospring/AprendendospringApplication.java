package com.vitormwxm.aprendendospring;

import com.vitormwxm.aprendendospring.infraestructure.entities.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AprendendospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AprendendospringApplication.class, args);

		Usuario usuario = new Usuario("Vitor", "Vitormwxm@gmail.com", "12345");

		System.out.println(usuario.getEmail());
	}
}
