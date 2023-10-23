package com.cloud.gcp.demo.gcpdemoproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cloud.gcp.demo.gcpdemoproject.domain.pojo.User;

//@Service
public interface UserService {

	List<User> findAllUsers();
}
