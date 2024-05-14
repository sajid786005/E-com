package com.codewithproject.ecomRepository;

import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithproject.ecomEnums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findFirstByEmail(String email);
	
	com.codewithproject.ecomEntity.User findByRole(UserRole userRole);

	com.codewithproject.ecomEntity.User save(com.codewithproject.ecomEntity.User user);

}
