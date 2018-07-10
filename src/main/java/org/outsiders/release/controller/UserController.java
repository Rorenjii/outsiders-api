package org.outsiders.release.controller;

import java.util.List;
import java.util.Optional;

import org.outsiders.release.domain.User;
import org.outsiders.release.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService userService){
        this.service = userService;
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") String userId) {
        User user = service.findById(userId).get();
        return user;
    }
    
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
    	User user = service.findByEmail(email);
    	return user;
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return service.findAll();
    }
    

    @PutMapping("/")
    public User updateUser(User u) throws Exception {
    	try {
	    	User a = service.findById(u.getId()).get();
	    	a.updateUser(u);
	    	User r = service.insert(a);
	        return r;
    	} catch (Exception e) {
    		throw e;
    	}
    }

    @PostMapping("/")
    public User postUser(@RequestBody User user) {
        return service.insert(user);
    }

    @DeleteMapping("/{userId}")
    public String deleteUserById(@PathVariable("userId") String userId) {
        service.deleteById(userId);
        return userId;
    }

    @DeleteMapping("/")
    public void deleteUserById() {
        service.deleteAll();
    }
}