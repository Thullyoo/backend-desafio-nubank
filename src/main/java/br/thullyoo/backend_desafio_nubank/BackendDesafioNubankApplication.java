package br.thullyoo.backend_desafio_nubank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BackendDesafioNubankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendDesafioNubankApplication.class, args);
	}

}
