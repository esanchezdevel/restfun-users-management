package online.restfun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.restfun.domain.Credential;
import online.restfun.domain.dto.AuthenticateRequestDTO;
import online.restfun.domain.dto.AuthenticateResponseDTO;
import online.restfun.mapping.AuthenticateMapping;
import online.restfun.repository.CredentialRepository;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {

	@Autowired
	private CredentialRepository credentialRepository;
	
	@Override
	public AuthenticateResponseDTO execute(AuthenticateRequestDTO request) {
		
		Credential credential = credentialRepository.findByKeyAndPassword(request.getKey(), request.getPassword());
		return AuthenticateMapping.buildAuthenticateResponseDTO(credential);
	}
}
