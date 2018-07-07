package org.outsiders.release.controller;

import java.util.UUID;

import org.outsiders.release.domain.User;
import org.outsiders.release.domain.dto.UserDTO;
import org.outsiders.release.domain.response.RegistrationResponse;
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
    public RegistrationResponse register(@RequestBody UserDTO dto) {
    	User user = new User();
    	user.setEmail(dto.getEmail());
    	user.setPassword(dto.getPassword());
    	
    	String id = UUID.randomUUID().toString();
    	
    	user.setId(id);
    	service.insert(user);
    	RegistrationResponse resp = new RegistrationResponse();
    	resp.setSuccess(true);
    	resp.setSummary("User created with id = " + id);
    	return resp;
    }
}
