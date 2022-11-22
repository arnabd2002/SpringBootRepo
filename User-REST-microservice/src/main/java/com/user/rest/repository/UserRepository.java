package com.user.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.rest.model.User;

public interface UserRepository extends JpaRepository<User,Integer>
{
	public User findById(int id);
	public User findByFirstname(String firstname);
	public User findByLastname(String lastname);
	
	
	
	
}
