package online.restfun.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import online.restfun.domain.Credential;
import online.restfun.domain.User;

public class Data {

	public static User createMockUser() {
		
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
		
		return user;
	}
}
