package com.user.rest.controller;

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

import com.user.rest.model.User;
import com.user.rest.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController 
{

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping("/findbyfirstname/{firstname}")
	public User getByFirstname(@PathVariable("firstname") String firstname)
	{
		return userService.findByFirstName(firstname);
	}
	
	@GetMapping("/findbylastname/{lastname}")
	public User getByLastname(@PathVariable("lastname") String lastname)
	{
		return userService.findByLastName(lastname);
	}
	
	@GetMapping("/findbyId/{id}")
	public User getById(@PathVariable("id") int id)
	{
		return userService.findUserById(id);
	}
	
	@PostMapping("/")
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}
	
	@PostMapping("/bulkInsert")
	public List<User> addBulkUsers(@RequestBody List<User> userList)
	{
		return userService.bulkInsert(userList);
	}
	
	
	
	@PutMapping("/")
	public User updateUser(@RequestBody User user)
	{
		return userService.updateUser(user);
	}
	
	@PutMapping("/bulkUpdate")
	public List<User> updateBulkUsers(@RequestBody List<User> userList)
	{
		return userService.bulkUpdate(userList);
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") Integer id)
	{
		return userService.deleteUser(id);
	}
	
	
	
	
	
}
