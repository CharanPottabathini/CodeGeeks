package com.sportsevent.backend.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportsevent.backend.entity.User;
import com.sportsevent.backend.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	//used for login into the application
	@PostMapping(value = "/login")
    public ResponseEntity<Map> verifyUser(@RequestBody User user){
System.out.println(user.toString());
		return ResponseEntity.status(HttpStatus.OK).body(userService.login(user));
	}
		//used for registering the application
	@PostMapping(value = "/register")
	public ResponseEntity<Map> registerUser(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.OK).body(userService.registerUser(user));
	}
	
	

}
