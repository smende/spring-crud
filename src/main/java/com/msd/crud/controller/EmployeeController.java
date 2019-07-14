package com.msd.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.msd.crud.domain.Employee;
import com.msd.crud.services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("")
	public List<Employee> getAllEmployees(){
		return this.employeeService.getAllEmployees();
	}
	
	@PostMapping("")
	public void saveEmployee(@RequestBody Employee employee) {
		this.employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id) {
		
		Optional<Employee> emp = this.employeeService.getEmployeeById(id);
		
		return this.employeeService.getEmployeeById(id);
	}
	
	
	
}
