package com.yvan.quiz_app;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizAppApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();

		// Access individual variables
		String dbUsername = dotenv.get("DB_USER");
		String dbPassword = dotenv.get("DB_PASSWORD");
		String dbUrl = dotenv.get("DB_URL");
		System.setProperty("spring.datasource.url",dbUrl);
		System.setProperty("spring.datasource.username", dbUsername);
		System.setProperty("spring.datasource.password", dbPassword);

		SpringApplication.run(QuizAppApplication.class, args);
	}

}
