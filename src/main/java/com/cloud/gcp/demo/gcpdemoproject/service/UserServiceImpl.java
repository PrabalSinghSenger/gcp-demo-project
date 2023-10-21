package com.cloud.gcp.demo.gcpdemoproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cloud.gcp.demo.gcpdemoproject.domain.pojo.User;
import com.google.common.collect.ImmutableList;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<User> findAllUsers() {
		
		List<User> users = ImmutableList.of( 
				new User(1,"Rohit", 36, "Mumbai"),
				new User(2,"Virat", 35, "Delhi"),
				new User(3,"Gill", 36, "Punjab"),
				new User(4,"KL Rahul", 36, "Karnatka"),
				new User(5,"Shreyas", 36, "Mumbai"));
		return users;
	}

}
