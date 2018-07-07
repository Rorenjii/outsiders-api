package org.outsiders.release.controller;

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
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public AuthResponse logIn(@RequestBody AuthRequest request) {
		AuthResponse response = new AuthResponse();
		try {
			User user = userService.findByEmail(request.getEmail());
			if (user.getPassword().equals(request.getPassword())) {
				response.setSuccess(true);
				response.setSummary(user.getId());
				response.setErrorCode(null);
				return response;
			} else {
				response.setSuccess(false);
				response.setErrorCode("Password did not match!");
				response.setSummary(null);
				return response;
			}
		} catch (Exception e) {
			response.setSuccess(false);
			response.setErrorCode(e.getMessage());
			response.setSummary("User not found by that Email");
			return response;
		}
	}
}
