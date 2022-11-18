package com.postgresql.user.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgresql.user.rest.model.User;
import com.postgresql.user.rest.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController
{
	@Autowired
	private IUserService userService;
	
	
	
	@GetMapping("/")
	public List<User> getAll()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User findUser(@PathVariable(name = "id") Integer id)
	{
		return userService.findByUserid(id);
	}
	
	@PostMapping("/")
	public User insertUser(@RequestBody User user)
	{
		return userService.insertUser(user);
	}
	
	@PutMapping("/")
	public User updateUser(@RequestBody User user)
	{
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/")
	public String deleteUser(@RequestBody User user)
	{
		return userService.deleteUser(user);
	}
}
