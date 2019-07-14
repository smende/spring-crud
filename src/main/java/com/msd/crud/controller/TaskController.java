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
import org.springframework.web.bind.annotation.RestController;

import com.msd.crud.domain.Task;
import com.msd.crud.domain.User;
import com.msd.crud.services.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping("")
	List<Task> getAll(){
		return this.taskService.getAll();
	}
	
	@PostMapping("")
	long save(@RequestBody Task task ) {

			return this.taskService.save(task);

	}
	
	@GetMapping("/{id}")
	Task getById(@PathVariable long id) {
	
		Optional<Task> task = this.taskService.getById(id);
		
		if(task.get() != null) {
				return task.get();
		}else {
			return null;
		}
		
	}
	
	@PutMapping("/{id}")
	boolean update(@RequestBody Task task, @PathVariable long id) {
		return this.taskService.update(id, task);
	}
	
	@DeleteMapping("/{id}")
	boolean delete(@PathVariable long id) {
		return this.taskService.delete(id);
	}
	
	@GetMapping("/byUser/{userId}")
	List<Task> taskByUserId(@PathVariable long userId ){
			return this.taskService.getTasksByUserId(userId);
	}
	
	@GetMapping("/byStatus/{status}")
	List<Task> taskByStatus(@PathVariable boolean status){
			return this.taskService.getTasksByStatus(status);
	}
}
