package online.restfun.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import online.restfun.data.Data;
import online.restfun.domain.Credential;
import online.restfun.service.GetCredentialsByEmailAndProductService;

@WebMvcTest
public class CredentialControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private GetCredentialsByEmailAndProductService getCredentialsByEmailAndProductService;
	
	@Test
	@DisplayName("test get by email and product")
	void testGetByEmailAndProduct() throws Exception {
		
		Credential credential = Data.createMockCredential();
		
		Optional<Credential> credentialOptional = Optional.of(credential); 
		
		when(getCredentialsByEmailAndProductService.execute(any(), any())).thenReturn(credentialOptional);
		
		mockMvc.perform(get("/users-management/v1/credentials?email=test%40mail.com&product=astrology"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.key").value("testKey"))
		.andExpect(jsonPath("$.password").value("testPassword"));
	}
}
