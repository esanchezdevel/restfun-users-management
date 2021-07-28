package online.restfun.mapping;

import online.restfun.domain.Credential;
import online.restfun.domain.dto.AuthenticateResponseDTO;

public class AuthenticateMapping {

	public static AuthenticateResponseDTO buildAuthenticateResponseDTO(Credential credential) {
		
		if (credential != null) {
			return new AuthenticateResponseDTO(credential.getProduct(), true);
		} else {
			return new AuthenticateResponseDTO("", false);
		}
	}
}
