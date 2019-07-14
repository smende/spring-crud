package com.msd.crud.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msd.crud.domain.Task;
import com.msd.crud.domain.User;
import com.msd.crud.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private UserService userService;
	
	public List<Task> getAll(){
		return (List<Task>) this.taskRepository.findAll();
	}
	
	public Optional<Task> getById(long id) {
		return this.taskRepository.findById(id);
	}
	
	public long save(Task task) {
		long userId = task.getUser().getId();
		
		if(this.userService.getUserById(userId).get() != null ) {
			
			task.setCreatedOn(new Date());
			return this.taskRepository.save(task).getId();
		}else {
			return 0;
		}
	
	}
	
	public boolean update(long id, Task task) {

		long userId = task.getUser().getId();
		
		if(id == task.getId() && this.userService.getUserById(userId).get() != null ) {
			 this.taskRepository.save(task);
			 return true;
		}else {
			return false;
		}
	}
	
	public boolean delete(long id) {
		try {
			this.taskRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Task> getTasksByStatus(boolean status){

		return this.taskRepository.findByStatus(status);
	}
	
	public List<Task> getTasksByUserId(long userId){

		return this.taskRepository.findByUserId(userId);
	}
}
