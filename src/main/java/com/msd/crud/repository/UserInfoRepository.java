package com.msd.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.msd.crud.domain.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{

	UserInfo findByUserId(long userId);
	
}
