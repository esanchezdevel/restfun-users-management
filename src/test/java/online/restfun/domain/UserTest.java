package online.restfun.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import online.restfun.data.Data;

@SpringBootTest
public class UserTest {

	@Test
	@DisplayName("test getters and setters")
	void testGettersAndSetters() {

		List<Credential> credentials = new ArrayList<>();

		User user = new User();

		user.setId(1L);
		user.setProduct("test");
		user.setEmail("test@mail.com");
		user.setPrice(0.01);
		user.setPriceWithVat(0.02);
		user.setVat("21%");
		user.setOrderId("12345");
		user.setCredentials(credentials);
		user.setCreated(LocalDate.now());
		user.setUpdated(LocalDate.now());

		assertNotNull(user);
		assertEquals(1L, user.getId());
		assertEquals("test", user.getProduct());
		assertEquals("test@mail.com", user.getEmail());
		assertEquals(0.01, user.getPrice());
		assertEquals(0.02, user.getPriceWithVat());
		assertEquals("21%", user.getVat());
		assertEquals("12345", user.getOrderId());
		assertEquals(credentials.size(), user.getCredentials().size());
		assertEquals(LocalDate.now().getDayOfMonth(), user.getCreated().getDayOfMonth());
		assertEquals(LocalDate.now().getMonth(), user.getCreated().getMonth());
		assertEquals(LocalDate.now().getYear(), user.getCreated().getYear());
		assertEquals(LocalDate.now().getDayOfMonth(), user.getUpdated().getDayOfMonth());
		assertEquals(LocalDate.now().getMonth(), user.getUpdated().getMonth());
		assertEquals(LocalDate.now().getYear(), user.getUpdated().getYear());
	}

	@Test
	@DisplayName("test all arguments contructor")
	void testAllArgumentsConstructor() {

		List<Credential> credentials = new ArrayList<>();

		User user = new User(1L, "test", "test@mail.com", 0.01, 0.02, "21%", "12345", credentials, LocalDate.now(),
				LocalDate.now());

		assertNotNull(user);
		assertEquals(1L, user.getId());
		assertEquals("test", user.getProduct());
		assertEquals("test@mail.com", user.getEmail());
		assertEquals(0.01, user.getPrice());
		assertEquals(0.02, user.getPriceWithVat());
		assertEquals("21%", user.getVat());
		assertEquals("12345", user.getOrderId());
		assertEquals(credentials.size(), user.getCredentials().size());
		assertEquals(LocalDate.now().getDayOfMonth(), user.getCreated().getDayOfMonth());
		assertEquals(LocalDate.now().getMonth(), user.getCreated().getMonth());
		assertEquals(LocalDate.now().getYear(), user.getCreated().getYear());
		assertEquals(LocalDate.now().getDayOfMonth(), user.getUpdated().getDayOfMonth());
		assertEquals(LocalDate.now().getMonth(), user.getUpdated().getMonth());
		assertEquals(LocalDate.now().getYear(), user.getUpdated().getYear());
	}

	@Test
	@DisplayName("test toString")
	void testToString() {

		User user = Data.createMockUser();

		String toString = String.format(
				"User(id=%s, product=%s, email=%s, price=%s, priceWithVat=%s, vat=%s, orderId=%s, credentials=%s, created=%s, updated=%s)",
				user.getId(), user.getProduct(), user.getEmail(), user.getPrice(), user.getPriceWithVat(),
				user.getVat(), user.getOrderId(), user.getCredentials(), user.getCreated(), user.getUpdated());

		assertEquals(toString, user.toString());
	}
}
