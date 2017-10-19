package com.es.employee.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.es.employee.domain.Employee;
import com.es.employee.service.EmployeeService;
import com.es.employee.dao.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService {
private EmployeeDao employeeDao;
/*在service中完成DAO的注入*/
public void setEmployeeDao(EmployeeDao employeeDao) {
	this.employeeDao = employeeDao;
}
/*业务层中的一种登录的方法*/
@Override
public Employee login(Employee employee) {
	// TODO Auto-generated method stub
	/*业务层想到完成登录的话，就需要调用Dao*/
	Employee existEmployee=employeeDao.findByUsernameAndPassword(employee);
	return existEmployee;
}
@Transactional
@Override
public void save(Employee employee) {
	employeeDao.save(employee);
	
}

}

