package com.sportsevent.backend.service;

import java.util.Map;

import com.sportsevent.backend.entity.User;

public interface UserService {
	
	public Map login(User user);
	
	public Map registerUser(User user);
}
