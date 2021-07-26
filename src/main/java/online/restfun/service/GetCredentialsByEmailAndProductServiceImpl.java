package online.restfun.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.restfun.domain.Credential;
import online.restfun.domain.User;
import online.restfun.repository.UserRepository;

@Service
public class GetCredentialsByEmailAndProductServiceImpl implements GetCredentialsByEmailAndProductService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<Credential> execute(String email, String product) {
		
		User user = userRepository.findByEmailAndProduct(email, product);
		
		Optional<Credential> credential = null;
		if (user.getCredentials() != null && user.getCredentials().size() > 0) {
			credential = Optional.of(user.getCredentials().get(0));
		} else {
			credential = Optional.empty();
		}
		
		return credential;
	}
}
