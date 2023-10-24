package com.cloud.gcp.demo.gcpdemoproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cloud.gcp.demo.gcpdemoproject.domain.pojo.User;


@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<User> findAllUsers() {
		
		List<User> users = new ArrayList<>();
		users.add(new User(1,"Rohit", 36, "Mumbai")); 
				
				users.add(new User(2,"Virat", 35, "Delhi"));
						users.add(new User(3,"Gill", 36, "Punjab"));
								users.add(new User(4,"KL Rahul", 36, "Karnatka"));
										users.add(new User(5,"Shreyas", 36, "Mumbai"));
		return users;
	}

}
