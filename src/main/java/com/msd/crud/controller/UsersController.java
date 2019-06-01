package com.msd.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msd.crud.domain.User;
import com.msd.crud.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public List<User> getAllUsers(){
		
		return this.userService.getUsers();
	}
	
	@RequestMapping(method = RequestMethod.POST )
	public int saveUser(@RequestBody User user) {
		return this.userService.saveUser(user);
	}
	
	@RequestMapping("/{userId}")
	public User getUserById(@PathVariable int userId) {
		return this.userService.getUserById(userId);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value ="/{userId}")
	public boolean updateUser(@PathVariable int userId, @RequestBody User user) {
			try {
				this.userService.updateUser(userId, user);
				return true;
			} catch (Exception e) {
				return false;
			}
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{userId}")
	public boolean deleteUser(@PathVariable int userId) {
		
		try {
			this.userService.deleteUser(userId);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
