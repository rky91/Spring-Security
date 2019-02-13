package com.spring.security.service;

import com.spring.security.domain.User;

public interface UserService {
	
	public User getUserById(Long id);
	public void saveUser(User user);
	public User findByUsername(String username);
	User findUserByEmail(String email);

}
