package com.example.h2.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.h2.api.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByDept(String dept);

}
