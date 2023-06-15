package com.example.helloworldspringopenjdk;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTests {
	@Autowired
	MockMvc mockMvc;

	@Test
	public void hello() throws Exception {
		this.mockMvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
			.andExpect(content().string("Hello World!"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "Darth Vader", "Mike", "Amy" })
	public void helloWithParams(String name) throws Exception {
		this.mockMvc.perform(get("/hello/{name}", name))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
			.andExpect(content().string("Hello " + name));
	}
}