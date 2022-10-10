package com.openwebinars.rest;

import com.openwebinars.rest.upload.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner initStorage(StorageService storageService){
		return args -> {
			//inicializamos el servicio de ficheros
			storageService.deleteAll();
			storageService.init();
		};
	}
}
