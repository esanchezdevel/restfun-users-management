package online.restfun.service;

import online.restfun.domain.dto.AuthenticateRequestDTO;
import online.restfun.domain.dto.AuthenticateResponseDTO;

public interface AuthenticateService {

	AuthenticateResponseDTO execute(AuthenticateRequestDTO request);
}
