package online.restfun.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import online.restfun.data.Data;
import online.restfun.domain.Credential;
import online.restfun.domain.dto.AuthenticateRequestDTO;
import online.restfun.domain.dto.AuthenticateResponseDTO;
import online.restfun.repository.CredentialRepository;

@SpringBootTest
public class AuthenticateServiceTest {

	@MockBean
	private CredentialRepository credentialRepository;
	
	@Autowired
	private AuthenticateService authenticateService;
	
	@Test
	@DisplayName("test authenticate")
	void testAuthenticate() {
		
		AuthenticateRequestDTO authenticateRequestDTO = new AuthenticateRequestDTO("testKey", "testPassword");
		Credential credential = Data.createMockCredential();
		
		when(credentialRepository.findByKeyAndPassword(any(), any())).thenReturn(credential);
		
		AuthenticateResponseDTO authenticateResponseDTO = authenticateService.execute(authenticateRequestDTO);
		
		assertNotNull(authenticateResponseDTO);
		assertEquals("test", authenticateResponseDTO.getProduct());
		assertTrue(authenticateResponseDTO.isAuthenticated());
	}
	
	@Test
	@DisplayName("test authenticate unauthorized")
	void testAuthenticateUnauthorized() {
		
		AuthenticateRequestDTO authenticateRequestDTO = new AuthenticateRequestDTO("testKey", "testPassword");
		
		when(credentialRepository.findByKeyAndPassword(any(), any())).thenReturn(null);
		
		AuthenticateResponseDTO authenticateResponseDTO = authenticateService.execute(authenticateRequestDTO);
		
		assertNotNull(authenticateResponseDTO);
		assertEquals("", authenticateResponseDTO.getProduct());
		assertFalse(authenticateResponseDTO.isAuthenticated());
	}
}
