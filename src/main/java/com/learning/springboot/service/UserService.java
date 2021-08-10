package com.learning.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboot.dao.UserRepository;
import com.learning.springboot.entities.User;

import java.util.List;


@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUser() {
		return this.userRepository.findAll();
	}
	
	
	public User createUser(User user) {
		return this.userRepository.save(user);
	}
}
