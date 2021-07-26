package online.restfun.mapping;

import online.restfun.domain.Credential;
import online.restfun.domain.dto.CredentialsDTO;

public class CredentialsMapping {

	public static CredentialsDTO buildCredentialsDTO(Credential credential) {

		return new CredentialsDTO(credential.getProduct(), credential.getKey(), credential.getPassword());
	}
}
