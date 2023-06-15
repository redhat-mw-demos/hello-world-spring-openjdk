package com.example.helloworldspringopenjdk;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping(path = { "/hello", "/hello/{name}" }, produces = MediaType.TEXT_PLAIN_VALUE)
	public String hello(@PathVariable Optional<String> name) {
		return "Hello " + name.orElse("World!");
	}
}
