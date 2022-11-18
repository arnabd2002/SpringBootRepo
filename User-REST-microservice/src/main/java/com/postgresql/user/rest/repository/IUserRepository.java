package com.postgresql.user.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgresql.user.rest.model.User;


public interface IUserRepository extends JpaRepository<User,Integer>
{
	User findByUserid(int id);
	
	
}
