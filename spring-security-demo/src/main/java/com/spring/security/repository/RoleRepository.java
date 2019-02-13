package com.spring.security.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.security.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	
	public Role findByName(String name);

}
