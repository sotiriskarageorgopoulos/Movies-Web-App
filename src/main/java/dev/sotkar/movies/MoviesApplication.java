package dev.sotkar.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication // This class runs the API
@RestController //This class is REST API
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@GetMapping("/") //Indicates GET Method
	public String root() {
		return "Movies REST API!";
	}
}
