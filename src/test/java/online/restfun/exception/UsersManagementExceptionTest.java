package online.restfun.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersManagementExceptionTest {

	@Test
	@DisplayName("test getters and setters")
	void testGettersAndSetters() {
		
		UsersManagementException exception = new UsersManagementException("test");
		
		assertEquals("test", exception.getError());
		
		exception.setError("new test");
		
		assertEquals("new test", exception.getError());
	}
	
	@Test
	@DisplayName("test toString")
	void testToString() {
		
		String toString = String.format("UsersManagementException(error=%s)", "test");
		
		UsersManagementException exception = new UsersManagementException("test");

		assertEquals(toString, exception.toString());
	}
}
