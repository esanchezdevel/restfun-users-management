package online.restfun.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import online.restfun.domain.Credential;
import online.restfun.service.GetCredentialsByEmailAndProductService;

@RestController
@RequestMapping("/credentials")
public class CredentialController {

	@Autowired
	private GetCredentialsByEmailAndProductService getCredentialsByEmailAndProductService;
	
	@GetMapping
	public ResponseEntity<?> getByEmailAndProduct(@RequestParam String email, @RequestParam String product) {
		
		Optional<Credential> credential = getCredentialsByEmailAndProductService.execute(email, product);
		
		if (credential.isPresent()) {
			return ResponseEntity.ok(credential.orElseThrow());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
