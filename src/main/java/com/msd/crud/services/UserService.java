package com.msd.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msd.crud.domain.User;
import com.msd.crud.repository.UsersRepository;

@Service
public class UserService {

	@Autowired
	private UsersRepository usersRepository;
	
	public String sayHi() {
		return "hello";
	}
	
	public List<User> getUsers(){
		
		List<User> list = (List<User>) this.usersRepository.findAll();
		
		return list;
	}
	
	public int saveUser(User user) {
		return this.usersRepository.save(user).getUserId();
	}

	public User getUserById(int userId) {
		return this.usersRepository.findOne(userId);
	}
	
	public void updateUser(int userId,User user) throws Exception {
			
		if(userId != user.getUserId()) {
			throw(new Exception("Can't Update user Id"));
		}
		else {
			this.usersRepository.save(user);
		}		
	}
	
	public void deleteUser(int userId) {
		this.usersRepository.delete(userId);
	}
}
