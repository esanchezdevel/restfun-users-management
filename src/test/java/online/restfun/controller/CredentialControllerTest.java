package online.restfun.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import online.restfun.domain.dto.AuthenticateRequestDTO;
import online.restfun.domain.dto.AuthenticateResponseDTO;
import online.restfun.service.AuthenticateService;

@WebMvcTest
public class CredentialControllerTest {
	
	private ObjectMapper objectMapper;
	
	@MockBean
	private AuthenticateService authenticateService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();
	}
	
	@Test
	@DisplayName("test authenticate")
	void testAuthenticate() throws Exception {
		
		AuthenticateRequestDTO authenticateRequestDTO = new AuthenticateRequestDTO("testKey", "testPassword");
		AuthenticateResponseDTO authenticateResponseDTO = new AuthenticateResponseDTO("testProduct", true);
		
		when(authenticateService.execute(any())).thenReturn(authenticateResponseDTO);
		
		mockMvc.perform(post("/credentials/authenticate").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(authenticateRequestDTO)))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.product").value("testProduct"))
		.andExpect(jsonPath("$.authenticated").value(true));
	}
	
	@Test
	@DisplayName("test authenticate unauthorized")
	void testAuthenticateUnauthorized() throws Exception {
		
		AuthenticateRequestDTO authenticateRequestDTO = new AuthenticateRequestDTO("testKey", "testPassword");
		AuthenticateResponseDTO authenticateResponseDTO = new AuthenticateResponseDTO("", false);
		
		when(authenticateService.execute(any())).thenReturn(authenticateResponseDTO);
		
		mockMvc.perform(post("/credentials/authenticate").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(authenticateRequestDTO)))
		.andExpect(status().isUnauthorized())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.product").value(""))
		.andExpect(jsonPath("$.authenticated").value(false));
	}
}
