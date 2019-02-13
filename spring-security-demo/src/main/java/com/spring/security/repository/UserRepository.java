package com.spring.security.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.security.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByName(String name);
	User findByEmail(String email);

}
