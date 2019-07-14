package com.msd.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.msd.crud.domain.Task;

public interface TaskRepository extends CrudRepository<Task,Long>{

	List<Task> findByStatus(boolean status);
	List<Task> findByUserId(long id);
}
