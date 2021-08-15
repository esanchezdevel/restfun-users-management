package online.restfun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import online.restfun.domain.Credential;
import online.restfun.domain.dto.AuthenticateRequestDTO;
import online.restfun.domain.dto.AuthenticateResponseDTO;
import online.restfun.encryption.factory.EncryptionFactory;
import online.restfun.mapping.AuthenticateMapping;
import online.restfun.repository.CredentialRepository;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {

	@Autowired
	private CredentialRepository credentialRepository;
	
	@Value("${encryption.key}")
	private String encryptionKey;
	
	@Override
	public AuthenticateResponseDTO execute(AuthenticateRequestDTO request) {
		
		Credential credential = null;
		
		String password = null;
		try {
			password = EncryptionFactory.buildEncryption().encrypt(request.getPassword(), encryptionKey);
		} catch (Exception e) {
			return AuthenticateMapping.buildAuthenticateResponseDTO(credential);
		}
		credential = credentialRepository.findByKeyAndPassword(request.getKey(), password);
		return AuthenticateMapping.buildAuthenticateResponseDTO(credential);
	}
}
