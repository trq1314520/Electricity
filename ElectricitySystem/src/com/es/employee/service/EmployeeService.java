package com.es.employee.service;

import com.es.employee.domain.Employee;

public interface EmployeeService {

	Employee login(Employee employee);

	void save(Employee employee);


}
