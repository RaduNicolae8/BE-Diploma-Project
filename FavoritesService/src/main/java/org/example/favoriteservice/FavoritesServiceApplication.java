package org.example.favoriteservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableFeignClients(basePackages = "org.example.favoriteservice.feingclients")
public class FavoritesServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(FavoritesServiceApplication.class, args);
	}

}
