package com.msd.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msd.crud.aspect.Loggable;
import com.msd.crud.domain.User;
import com.msd.crud.domain.UserInfo;
import com.msd.crud.services.UserInfoService;

@RestController
@RequestMapping("/api/userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping("")
	List<UserInfo> getAll(){
		return this.userInfoService.getAll();
	}
	
	@GetMapping("/currentUser")
	public UserInfo getCurrentUser() {
		return this.userInfoService.getCurrentUserInfo();
	}
	@Loggable
	@GetMapping("/{id}")
	UserInfo getUserInfoById(@PathVariable long id){	
		return this.userInfoService.getUserInfoById(id).get();
	}
	
	@PostMapping("")	
	long saveUserInfo(@RequestBody UserInfo userInfo) {
		 return this.userInfoService.saveUserInfo(userInfo);	
	}
	
	@PutMapping("/{id}")
	boolean update(@PathVariable long id,@RequestBody UserInfo userInfo) {
		return this.userInfoService.updateUserInfo(id, userInfo);
	}
	
	@DeleteMapping("/{id}")
	boolean delete(@PathVariable long id) {
		return this.userInfoService.deleteUserInfo(id);
	}
	
	@GetMapping("/byUserId/{userId}")
	UserInfo getUserInfoByUserId(@PathVariable long userId){
		return this.userInfoService.getUserInfoByUserId(userId);
	}
	
}
