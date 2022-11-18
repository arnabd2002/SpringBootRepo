package com.postgresql.user.rest.service;

import java.util.List;

import com.postgresql.user.rest.model.User;

public interface IUserService	
{
	List<User> getAllUsers();
	User findByUserid(Integer id );
	
	User insertUser(User user);
	User updateUser(User user);
	String deleteUser(User user);
}
