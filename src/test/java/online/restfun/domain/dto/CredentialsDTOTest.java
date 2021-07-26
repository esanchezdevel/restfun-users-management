package online.restfun.domain.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CredentialsDTOTest {

	@Test
	@DisplayName("test getters and setters")
	void testGettersAndSetters() {
		
		CredentialsDTO dto = new CredentialsDTO("astrology", "testKey", "testPassword");
		
		assertEquals("astrology", dto.getProduct());
		assertEquals("testKey", dto.getKey());
		assertEquals("testPassword", dto.getPassword());
	}
	
	@Test
	@DisplayName("test toString")
	void testToString() {
		
		String toString = "CredentialsDTO(product=astrology, key=testKey, password=testPassword)";
		
		CredentialsDTO dto = new CredentialsDTO("astrology", "testKey", "testPassword");

		assertEquals(toString, dto.toString());
	}
}
