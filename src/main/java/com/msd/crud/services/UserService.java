package com.msd.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msd.crud.domain.User;
import com.msd.crud.repository.UserPaginationRepository;
import com.msd.crud.repository.UsersRepository;

@Service
public class UserService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private UserPaginationRepository usersPaginationRepository;
	@Autowired
	private Environment env;
	
	public List<User> getUsers(){
		
		List<User> list = (List<User>) this.usersRepository.findAll();
		
		return list;
	}
	
	public long saveUser(User user){
		return this.usersRepository.save(user).getId();
	}
	
	@Transactional
	public void bulkSave(List<User> users) throws Exception {
		
		if(users.size()>0) {
			
				for(User user:users) {
					
						if(user.getFirstName()==null) {
							throw(new Exception());
						}
					
					this.saveUser(user);
				}			
		}
		
	}

	public Optional<User> getUserById(long id) {
		return this.usersRepository.findById(id);
	}
	
	public void updateUser(int userId,User user) throws Exception {
			
		if(userId != user.getId()) {
			throw(new Exception("Can't Update user Id"));
		}
		else {
			this.usersRepository.save(user);
		}		
	}
	
	public void deleteUser(long userId) {
		this.usersRepository.deleteById(userId);;
	}
	
	public List<User> getUsersByFirstName(String firstName){
		
		return this.usersRepository.findByFirstName(firstName);
	}
	
	public List<User> getUsersByAge(int age){
		return this.usersRepository.findByAge(age);
	}
	
	public long getUsersCount() {
		return this.usersRepository.count();
	}
	
	public Page<User> getUsersByPagination(int page,int size){
		return this.usersPaginationRepository.findAll(PageRequest.of(page,size));
	}

	public Optional<User> getCurrentUser() {
		
		String localUserId = env.getProperty("app.localUserId");
		return this.getUserById(Long.parseLong(localUserId));
	}
}
