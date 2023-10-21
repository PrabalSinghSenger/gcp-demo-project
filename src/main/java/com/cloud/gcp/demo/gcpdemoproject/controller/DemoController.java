package com.cloud.gcp.demo.gcpdemoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.gcp.demo.gcpdemoproject.domain.pojo.User;
import com.cloud.gcp.demo.gcpdemoproject.service.UserService;

@RestController
@RequestMapping(value = "/demo/")
public class DemoController {

	@Autowired UserService userService;
	
	@RequestMapping(value = "/users")
	public List<User> getUsers() {
		return userService.findAllUsers();
	}

}
