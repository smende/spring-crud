package com.msd.crud.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.hql.spi.id.inline.IdsClauseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msd.crud.domain.Employee;
import com.msd.crud.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public List<Employee> getAllEmployees(){
		
		return (List<Employee>) this.employeeRepository.findAll();
	}
	
	
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}
	
	public Optional<Employee> getEmployeeById(int id) {
			return this.employeeRepository.findById(id);
			
	}
	
	
	
	
}
