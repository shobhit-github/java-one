package com.learning.springboot.controller;

import java.util.List;

import com.learning.springboot.dao.UserRepository;
import com.learning.springboot.utilities.constants.ErrorResponseMessage;
import com.learning.springboot.utilities.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.learning.springboot.entities.User;
import com.learning.springboot.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;

@RestController
@RequestMapping(path = {"/User"})
@Tag(name = "User Management", description = "This Section will have all user related apis")
public class UserController {


	private final UserService userService;
	private final UserRepository userRepository;

	public UserController(UserService userService, UserRepository userRepository) {
		this.userService = userService;
		this.userRepository = userRepository;
	}


	@GetMapping(path = {"/retrieveAll"}, produces = "application/json")
	@Operation(summary = "getListOfUser", description = "this api help to fetch list of user record" )
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@GetMapping(path = {"/retrieveById/{id}"}, produces = "application/json")
	@Operation(summary = "getUserById", description = "this api help to fetch list of user record" )
	public User getUserById(@PathVariable Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(ErrorResponseMessage.USER_IS_NOT_EXIST));
	}

	@PostMapping(path = {"/createNew"}, consumes = {"application/json"}, produces = "application/json")
	@Operation(summary = "createNewUser", description = "this api help to add new record of the user")
	public User createNewUser( @Valid @RequestBody User user) {
		return userRepository.save(user);
	}

}
