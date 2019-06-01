package com.msd.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.msd.crud.domain.User;

public interface UsersRepository extends CrudRepository<User, Integer>{

}
