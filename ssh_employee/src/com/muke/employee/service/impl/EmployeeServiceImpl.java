package com.muke.employee.service.impl;
import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.domain.Employee;
/*ҵ�����Ҫȥ����dao��*/
import com.muke.employee.service.EmployeeService;
/*Ա�������ҵ����ʵ����*/
/*ʵ�ֵĹ�����actionȥ����service�㣬serviceȥ����dao�㣬Ȼ��ȥ������ݿ��һ����ѯ����*/
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

}
