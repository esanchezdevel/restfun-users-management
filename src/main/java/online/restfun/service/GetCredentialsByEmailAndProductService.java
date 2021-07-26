package online.restfun.service;

import java.util.Optional;

import online.restfun.domain.dto.CredentialsDTO;

public interface GetCredentialsByEmailAndProductService {

	Optional<CredentialsDTO> execute(String email, String product);
}
