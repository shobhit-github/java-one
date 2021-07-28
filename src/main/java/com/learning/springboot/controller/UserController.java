package com.learning.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.entities.User;
import com.learning.springboot.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = {"/User"})
@Tag(name = "User Management", description = "This Section will have all user related apis")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = {"/allUsers"})
	@Operation(summary = "getListOfUser", description = "this api help to fetch list of user record" )
	public List<User> getAllUser() {
		return this.userService.getAllUser();
	}
	
	@PostMapping(path = {"/saveNewUser"}, consumes = {"application/json"})
	@Operation(summary = "createNewUser", description = "this api help to add new record of the user" )
	public User createNewUser(@RequestBody User user) {

		return this.userService.createUser(user);
	}

}