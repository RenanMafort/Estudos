package com.sereia.renan.hrconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class HrConfigServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

	@Value("${spring.cloud.config.server.git.username}")
	private String username;
	@Value("${spring.cloud.config.server.git.password}")
	private String password;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(username);
		System.out.println(password);
	}
}
