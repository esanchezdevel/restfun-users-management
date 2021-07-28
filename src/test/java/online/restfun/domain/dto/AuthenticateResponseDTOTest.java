package online.restfun.domain.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthenticateResponseDTOTest {

	@Test
	@DisplayName("test getters and setters")
	void testGettersAndSetters() {
		
		AuthenticateResponseDTO response = new AuthenticateResponseDTO("testProduct", true);
		
		assertEquals("testProduct", response.getProduct());
		assertTrue(response.isAuthenticated());
		
		response.setProduct("newProduct");
		response.setAuthenticated(false);
		
		assertEquals("newProduct", response.getProduct());
		assertFalse(response.isAuthenticated());
	}
	
	@Test
	@DisplayName("test toString")
	void testToString() {
		
		AuthenticateResponseDTO response = new AuthenticateResponseDTO("testProduct", true);
		
		String toString = "AuthenticateResponseDTO(product=testProduct, authenticated=true)";
		
		assertEquals(toString, response.toString());
	}
}
