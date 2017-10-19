package com.es.employee.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.es.employee.domain.Employee;
import com.es.employee.service.EmployeeService;
import com.es.employee.dao.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService {
private EmployeeDao employeeDao;
/*��service�����DAO��ע��*/
public void setEmployeeDao(EmployeeDao employeeDao) {
	this.employeeDao = employeeDao;
}
/*ҵ����е�һ�ֵ�¼�ķ���*/
@Override
public Employee login(Employee employee) {
	// TODO Auto-generated method stub
	/*ҵ����뵽��ɵ�¼�Ļ�������Ҫ����Dao*/
	Employee existEmployee=employeeDao.findByUsernameAndPassword(employee);
	return existEmployee;
}
@Transactional
@Override
public void save(Employee employee) {
	employeeDao.save(employee);
	
}

}

