package com.example.h2.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2.api.dao.EmployeeRepository;
import com.example.h2.api.model.Employee;

@RestController
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
	
	@Autowired
	public EmployeeRepository respository;
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody Employee employee) {
		respository.save(employee);	
		return "Employee save succesfully....";
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		List<Employee> employees= new ArrayList<Employee>();
		 respository.findAll().forEach(employee -> employees.add(employee));
        return employees;
	}
	
	@GetMapping("/getEmployee/{dept}")
	public List<Employee> getEmployeeByDept(@PathVariable String dept){
		return respository.findByDept(dept);
	}

}
