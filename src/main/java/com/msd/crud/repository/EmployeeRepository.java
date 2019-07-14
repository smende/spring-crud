package com.msd.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.msd.crud.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
