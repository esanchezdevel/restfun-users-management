package online.restfun.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter @AllArgsConstructor @ToString
public class CredentialsDTO {

	private String product;
	
	private String key;
	
	private String password;
}
