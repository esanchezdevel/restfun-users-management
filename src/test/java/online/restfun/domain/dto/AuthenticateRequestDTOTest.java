package online.restfun.domain.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthenticateRequestDTOTest {

	@Test
	@DisplayName("test getters and setters")
	void testGettersAndSetters() {
		
		AuthenticateRequestDTO request = new AuthenticateRequestDTO("testKey", "testPassword");
		
		assertEquals("testKey", request.getKey());
		assertEquals("testPassword", request.getPassword());
		
		request.setKey("newKey");
		request.setPassword("newPassword");
		
		assertEquals("newKey", request.getKey());
		assertEquals("newPassword", request.getPassword());
	}
	
	@Test
	@DisplayName("test toString")
	void testToString() {
		
		AuthenticateRequestDTO request = new AuthenticateRequestDTO("testKey", "testPassword");
		
		String toString = "AuthenticateRequestDTO(key=testKey, password=testPassword)";
		
		assertEquals(toString, request.toString());
	}
}
