package com.es.employee.service;

import com.es.employee.domain.Employee;
import com.es.employee.domain.PageBean;

public interface EmployeeService {

	Employee login(Employee employee);

	void save(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);


}
