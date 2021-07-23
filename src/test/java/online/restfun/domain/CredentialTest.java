package online.restfun.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import online.restfun.data.Data;

@SpringBootTest
public class CredentialTest {

	@Test
	@DisplayName("test getters and setters")
	void testGettersAndSetters() {

		User user = Data.createMockUser();

		Credential credential = new Credential();
		credential.setId(1L);
		credential.setProduct("test");
		credential.setUser(user);
		credential.setKey("testKey");
		credential.setPassword("testPassword");
		credential.setEnabled(true);
		credential.setCreated(LocalDate.now());
		credential.setUpdated(LocalDate.now());

		assertNotNull(credential);
		assertEquals(1L, credential.getId());
		assertEquals("test", credential.getProduct());
		assertEquals("test@mail.com", credential.getUser().getEmail());
		assertEquals("testKey", credential.getKey());
		assertEquals("testPassword", credential.getPassword());
		assertTrue(credential.getEnabled());
		assertEquals(LocalDate.now().getDayOfMonth(), credential.getCreated().getDayOfMonth());
		assertEquals(LocalDate.now().getMonth(), credential.getCreated().getMonth());
		assertEquals(LocalDate.now().getYear(), credential.getCreated().getYear());
		assertEquals(LocalDate.now().getDayOfMonth(), credential.getUpdated().getDayOfMonth());
		assertEquals(LocalDate.now().getMonth(), credential.getUpdated().getMonth());
		assertEquals(LocalDate.now().getYear(), credential.getUpdated().getYear());
	}

	@Test
	@DisplayName("test all arguments contructor")
	void testAllArgumentsConstructor() {

		User user = Data.createMockUser();

		Credential credential = new Credential(1L, "test", user, "testKey", "testPassword", true, LocalDate.now(),
				LocalDate.now());

		assertNotNull(credential);
		assertEquals(1L, credential.getId());
		assertEquals("test", credential.getProduct());
		assertEquals("test@mail.com", credential.getUser().getEmail());
		assertEquals("testKey", credential.getKey());
		assertEquals("testPassword", credential.getPassword());
		assertTrue(credential.getEnabled());
		assertEquals(LocalDate.now().getDayOfMonth(), credential.getCreated().getDayOfMonth());
		assertEquals(LocalDate.now().getMonth(), credential.getCreated().getMonth());
		assertEquals(LocalDate.now().getYear(), credential.getCreated().getYear());
		assertEquals(LocalDate.now().getDayOfMonth(), credential.getUpdated().getDayOfMonth());
		assertEquals(LocalDate.now().getMonth(), credential.getUpdated().getMonth());
		assertEquals(LocalDate.now().getYear(), credential.getUpdated().getYear());
	}

	@Test
	@DisplayName("test toString")
	void testToString() {
		User user = Data.createMockUser();

		Credential credential = new Credential(1L, "test", user, "testKey", "testPassword", true, LocalDate.now(),
				LocalDate.now());

		String toString = String.format(
				"Credential(id=%s, product=%s, user=%s, key=%s, password=%s, enabled=%s, created=%s, updated=%s)",
				credential.getId(), credential.getProduct(), credential.getUser(), credential.getKey(),
				credential.getPassword(), credential.getEnabled(), credential.getCreated(), credential.getUpdated());
		;

		assertEquals(toString, credential.toString());

	}
}
