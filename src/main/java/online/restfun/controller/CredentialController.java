package online.restfun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.restfun.domain.dto.AuthenticateRequestDTO;
import online.restfun.domain.dto.AuthenticateResponseDTO;
import online.restfun.service.AuthenticateService;

@RestController
@RequestMapping("/credentials")
public class CredentialController {

	@Autowired
	private AuthenticateService authenticateService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequestDTO request) {
		
		AuthenticateResponseDTO response = authenticateService.execute(request);
		
		if (response.isAuthenticated()) {
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}
	}
}
