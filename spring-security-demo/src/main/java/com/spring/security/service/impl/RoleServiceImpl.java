package com.spring.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.domain.Role;
import com.spring.security.repository.RoleRepository;

@Service
public class RoleServiceImpl {
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	public Role getRolesByUserName(String userName){
		
		return roleRepository.findByName(userName);
		
	}
	
	public void saveRole(Role roles) {
		roleRepository.save(roles);
	}

}
