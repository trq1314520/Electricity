package com.es.employee.dao;

import com.es.employee.domain.Employee;

public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	void save(Employee employee);



}
