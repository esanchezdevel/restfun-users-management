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
import online.restfun.domain.dto.CredentialsDTO;
import online.restfun.mapping.CredentialsMapping;
import online.restfun.service.GetCredentialsByEmailAndProductService;

@WebMvcTest
public class CredentialControllerTest {
	
	@MockBean
	private GetCredentialsByEmailAndProductService getCredentialsByEmailAndProductService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("test get by email and product")
	void testGetByEmailAndProduct() throws Exception {
		
		Credential credential = Data.createMockCredential();
		
		Optional<CredentialsDTO> credentialOptional = Optional.of(CredentialsMapping.buildCredentialsDTO(credential)); 
		
		when(getCredentialsByEmailAndProductService.execute(any(), any())).thenReturn(credentialOptional);
		
		mockMvc.perform(get("/credentials?email=test%40mail.com&product=astrology"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.key").value("testKey"))
		.andExpect(jsonPath("$.password").value("testPassword"));
	}
	
	@Test
	@DisplayName("test credential not found")
	void testCredentialNotFound() throws Exception {
		
		Optional<CredentialsDTO> credentialOptional = Optional.empty(); 
		
		when(getCredentialsByEmailAndProductService.execute(any(), any())).thenReturn(credentialOptional);
		
		mockMvc.perform(get("/credentials?email=test%40mail.com&product=astrology"))
		.andExpect(status().isNoContent());
	}
}
