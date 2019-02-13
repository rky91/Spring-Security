package com.spring.security.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.security.domain.Role;
import com.spring.security.domain.User;
import com.spring.security.repository.RoleRepository;
import com.spring.security.repository.UserRepository;
import com.spring.security.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
	
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    @Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}
	
    @Override
	public void saveUser(User user) {
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByName("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
	}
	
    @Override
    public User findByUsername(String username) {
        return userRepository.findByName(username);
    }
	
}
