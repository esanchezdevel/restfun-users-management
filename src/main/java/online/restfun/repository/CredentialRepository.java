package online.restfun.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import online.restfun.domain.Credential;

@Repository
public interface CredentialRepository extends PagingAndSortingRepository<Credential, Long>{

	Credential findByKeyAndPassword(String key, String password);
}
