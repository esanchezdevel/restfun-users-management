package online.restfun.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import online.restfun.domain.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>{

	User findByEmailAndProduct(String email, String product);
}
