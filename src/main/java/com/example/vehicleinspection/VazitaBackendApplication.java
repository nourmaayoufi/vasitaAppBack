package com.example.vehicleinspection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(
		exclude = { RedisRepositoriesAutoConfiguration.class },
		scanBasePackages = { "com.example.vehicleinspection" }
)
@EntityScan(basePackages = {
		"com.example.vehicleinspection.model",
		"com.example.vehicleinspection.config.datasource"
})
@EnableJpaRepositories(basePackages = {
		"com.example.vehicleinspection.repository",
		"com.example.vehicleinspection.config.datasource"
})
public class VazitaBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(VazitaBackendApplication.class, args);
	}
}
