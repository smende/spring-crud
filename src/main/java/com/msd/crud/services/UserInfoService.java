package com.msd.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.msd.crud.domain.User;
import com.msd.crud.domain.UserInfo;
import com.msd.crud.repository.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private Environment env;
	
	public List<UserInfo> getAll(){
			return (List<UserInfo>) this.userInfoRepository.findAll();
	}
		
	
	public Optional<UserInfo> getUserInfoById(long id){
			
		Optional<UserInfo> userInfo = this.userInfoRepository.findById(id);
		return userInfo;
	}
	
	public long saveUserInfo(UserInfo userInfo ) {
		return this.userInfoRepository.save(userInfo).getId();
	}
	
	public boolean updateUserInfo(long id,UserInfo userInfo) {
		if(id == userInfo.getId())
		{
			this.userInfoRepository.save(userInfo);
			return true;
		}
		else
			return false;
	}
	
	public boolean deleteUserInfo(long id) {
		
		try {
			this.userInfoRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public UserInfo getUserInfoByUserId(long userId){
		return this.userInfoRepository.findByUserId(userId);
	}


	public UserInfo getCurrentUserInfo() {
		String localUserId = env.getProperty("app.localUserId");		
		return this.getUserInfoByUserId(Long.parseLong(localUserId));
	}
	
}
