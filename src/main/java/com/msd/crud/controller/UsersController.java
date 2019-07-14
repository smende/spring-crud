package com.msd.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msd.crud.aspect.Loggable;
import com.msd.crud.domain.User;
import com.msd.crud.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping("sayHello")
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping("/currentUser")
	public Optional<User> getCurrentUser() {
		return this.userService.getCurrentUser();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAllUsers(){
		
		return this.userService.getUsers();
	}
	
	@RequestMapping(method = RequestMethod.POST )
	public long saveUser(@RequestBody User user) {
		return this.userService.saveUser(user);
	}
	
	@PostMapping("/bulkSave")
	public void bulkSave(@RequestBody List<User> users) throws Exception {
		this.userService.bulkSave(users);
	}
	
	@Loggable
	@RequestMapping("/{id}")
	public User getUserById(@PathVariable long id) {
		
		Optional<User> user = this.userService.getUserById(id);
		return user.get();
		
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
	public boolean deleteUser(@PathVariable long userId) {
		
		try {
			this.userService.deleteUser(userId);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	@RequestMapping("findByFirstName/{firstName}")
	public List<User> getUsersByName(@PathVariable String firstName){
		
		return this.userService.getUsersByFirstName(firstName);
	}

	@RequestMapping("/findByAge/{age}")
	public List<User> getUsersByAge(@PathVariable int age){
		return this.userService.getUsersByAge(age);
	}
	
	@GetMapping("/count")
	public long getUsersCount(){
		return this.userService.getUsersCount();
	}
	
	@GetMapping("/page/{pageNo}/size/{size}")
	public Page<User> getFiveUsers(@PathVariable int pageNo,@PathVariable int size) {
		return this.userService.getUsersByPagination(pageNo,size);
	}
	
}
