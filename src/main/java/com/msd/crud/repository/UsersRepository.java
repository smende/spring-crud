package com.msd.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.msd.crud.domain.User;
import java.lang.String;
import java.util.List;

public interface UsersRepository extends CrudRepository<User, Long>{

	List<User> findByFirstName(String firstname);

	List<User> findByAge(int age);
	
	long count();

}
