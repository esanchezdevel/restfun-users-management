package online.restfun.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import online.restfun.data.Data;
import online.restfun.domain.Credential;
import online.restfun.domain.User;
import online.restfun.repository.UserRepository;

@SpringBootTest
public class GetCredentialsByEmailAndProductServiceTest {

	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	private GetCredentialsByEmailAndProductService getCredentialsByEmailAndProductService;
	
	@Test
	@DisplayName("test get credentials")
	void testGetCredentials() {
		
		String email = "test@mail.com";
		String product = "astrology";
		
		User user = Data.createMockUserWithCredentials();
		
		when(userRepository.findByEmailAndProduct(any(), any())).thenReturn(user);
		
		Optional<Credential> result = getCredentialsByEmailAndProductService.execute(email, product);
		
		assertNotNull(result);
		assertTrue(result.isPresent());
		assertEquals("testKey", result.get().getKey());
		assertEquals("testPassword", result.get().getPassword());
	}
	
	@Test
	@DisplayName("test get credentials not found")
	void testGetCredentialsNotFound() {
		
		String email = "test@mail.com";
		String product = "astrology";
		
		User user = Data.createMockUser();
		
		when(userRepository.findByEmailAndProduct(any(), any())).thenReturn(user);
		
		Optional<Credential> result = getCredentialsByEmailAndProductService.execute(email, product);
		
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}
	
	@Test
	@DisplayName("test get credentials not found and null")
	void testGetCredentialsNotFoundAndNull() {
		
		String email = "test@mail.com";
		String product = "astrology";
		
		User user = Data.createMockUserWithoutCredentials();
		
		when(userRepository.findByEmailAndProduct(any(), any())).thenReturn(user);
		
		Optional<Credential> result = getCredentialsByEmailAndProductService.execute(email, product);
		
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}
}
