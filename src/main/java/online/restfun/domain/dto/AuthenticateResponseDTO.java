package online.restfun.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @ToString
public class AuthenticateResponseDTO {

	private String product;
	
	private boolean authenticated;
}
