package com.user.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.rest.model.User;
import com.user.rest.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	//get ops
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	public User findUserById(int id)
	{
		return userRepository.findById(id);
	}
	
	public User findByFirstName(String firstname)
	{
		return userRepository.findByFirstname(firstname);
	}
	
	public User findByLastName(String lastname)
	{
		return userRepository.findByLastname(lastname);
	}
	
	//post ops
	
	public User addUser(User user)
	{
		User existingUser=userRepository.findById(user.getId());
		if(existingUser==null)
		{
			return userRepository.save(user);
		}
		else
		{
			return null;
		
		}
	}
	
	
	public User updateUser(User user)
	{
		User existingUser=userRepository.findById(user.getId());
		if(existingUser==null)
		{
			
			return null;
		}
		else
		{
			System.out.println("existing user:"+existingUser);
			existingUser.setId(existingUser.getId());
			existingUser.setFirstname(user.getFirstname());
			existingUser.setLastname(user.getLastname());
			existingUser.setSalary(user.getSalary());
			
			userRepository.save(existingUser);
			return existingUser;
		
		}
	}
	
	public List<User> bulkInsert(List<User> userList)
	{
		List<User> tempUserList=new ArrayList<User>();
		for(User u:userList)
		{
			User user=addUser(u);
			tempUserList.add(user);
		}
		return tempUserList;
	}
	
	public List<User> bulkUpdate(List<User> userList)
	{
		List<User> tempUserList=new ArrayList<User>();
		for(User u:userList)
		{
			User user=updateUser(u);
			tempUserList.add(user);
		}
		return tempUserList;
	}
	
	
	//delete ops
	public String deleteUser(int id)
	{
		User existingUser=userRepository.findById(id);
		if(existingUser!=null)
		{
			userRepository.delete(existingUser);
			return "User"+existingUser.getId()+" deleted successfully!!";
		}
		else
		{
			return "ERROR:User with :"+id+" does not exist";
		}
	}
	
}
