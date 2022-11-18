package com.postgresql.user.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresql.user.rest.model.User;
import com.postgresql.user.rest.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService
{

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		return userRepository.findAll();
	}

	@Override
	public User findByUserid(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findByUserid(id);
	}

	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		
		return userRepository.save(user);
		
		
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		User existing_user=userRepository.findByUserid(user.getUserid());
		if(existing_user!=null)
		{
			existing_user.setUserid(user.getUserid());
			existing_user.setUsername(user.getUsername());
			return userRepository.save(existing_user);
		}
		else
		{
			return null;
		}
	}

	@Override
	public String deleteUser(User user) 
	{
		User existingUser=userRepository.findByUserid(user.getUserid());
		if(existingUser!=null)
		{
			userRepository.delete(existingUser);
			return "Successfully deleted user:"+user.getUsername();
		}
		else
		{
			return "ERROR:Unable to delete.User:"+user.getUsername()+" does not exist";
		}
	}
	
	
}
