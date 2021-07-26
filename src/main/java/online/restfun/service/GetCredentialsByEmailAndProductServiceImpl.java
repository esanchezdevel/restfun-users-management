package online.restfun.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.restfun.domain.User;
import online.restfun.domain.dto.CredentialsDTO;
import online.restfun.mapping.CredentialsMapping;
import online.restfun.repository.UserRepository;

@Service
public class GetCredentialsByEmailAndProductServiceImpl implements GetCredentialsByEmailAndProductService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<CredentialsDTO> execute(String email, String product) {
		
		User user = userRepository.findByEmailAndProduct(email, product);
		
		Optional<CredentialsDTO> credential = null;
		if (user.getCredentials() != null && user.getCredentials().size() > 0) {
			
			CredentialsDTO credentialsDTO = CredentialsMapping.buildCredentialsDTO(user.getCredentials().get(0));
			
			credential = Optional.of(credentialsDTO);
		} else {
			credential = Optional.empty();
		}
		
		return credential;
	}
}
