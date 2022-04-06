package com.example.employeemanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired 
	private EmployeeRepo emplrep;
	
	public Employee fetchEmployeeByUsernameAndPassword(String username, String password) {
		return emplrep.findByUsernameAndPassword(username, password);
	}
}
