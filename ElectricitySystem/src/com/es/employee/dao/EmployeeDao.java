package com.es.employee.dao;

import com.es.employee.domain.Employee;

import java.util.List;

public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	void save(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);



}
