package com.example.cardatabase;

import static 
org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static 
org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static 
org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JWTTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testAuthentication() throws Exception {
		// correct credentials
		this.mockMvc.perform(post("/login")
				.content("{\"username\":\"admin\", \"password\":\"admin\"}"))
				.andDo(print()).andExpect(status().isOk());
		
		// wrong credentials
		this.mockMvc.perform(post("/login")
				.content("{\"username\":\"admin\", \"password\":\"wrong\"}"))
				.andDo(print()).andExpect(status().is4xxClientError());
	}
	
}
