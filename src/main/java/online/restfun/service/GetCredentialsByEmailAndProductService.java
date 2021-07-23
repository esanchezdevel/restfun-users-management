package online.restfun.service;

import java.util.Optional;

import online.restfun.domain.Credential;

public interface GetCredentialsByEmailAndProductService {

	Optional<Credential> execute(String email, String product);
}
