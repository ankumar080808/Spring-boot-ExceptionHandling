package com.anant.SpringbootExceptionHandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anant.SpringbootExceptionHandling.dto.UserRequest;
import com.anant.SpringbootExceptionHandling.entity.User;
import com.anant.SpringbootExceptionHandling.exception.UserNotFoundException;
import com.anant.SpringbootExceptionHandling.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest)
	{
		User user=userService.saveUser(userRequest);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> getAllUsers()
	{
		return ResponseEntity.ok(userService.getALlUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) throws UserNotFoundException
	{
		return ResponseEntity.ok(userService.getUser(id));
	}

}
