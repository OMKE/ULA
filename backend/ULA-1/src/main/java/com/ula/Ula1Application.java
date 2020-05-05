package com.ula;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class Ula1Application {

	@Value("${token.secret}")
	private String secret;

	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public ResponseEntity<String> index() {

		return new ResponseEntity<String>(this.secret, HttpStatus.OK);
	}

	public static void main(String[] args) {
		SpringApplication.run(Ula1Application.class, args);
	}

}
