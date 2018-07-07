package org.outsiders.release.controller;

import java.util.UUID;

import org.outsiders.release.domain.User;
import org.outsiders.release.domain.request.AuthRequest;
import org.outsiders.release.domain.response.AuthResponse;
import org.outsiders.release.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {
	
	private UserService service;
	
    @Autowired
    public RegistrationController(UserService userService){
        this.service = userService;
    }
	
    @PostMapping("/")
    public AuthResponse register(@RequestBody AuthRequest request) {
    	User user = new User();
    	user.setEmail(request.getEmail());
    	user.setPassword(request.getPassword());
    	
    	String id = UUID.randomUUID().toString();
    	
    	user.setId(id);
    	service.insert(user);
    	AuthResponse resp = new AuthResponse();
    	resp.setSuccess(true);
    	resp.setSummary("User created with id = " + id);
    	return resp;
    }
}
