package com.muke.employee.dao;

import com.muke.employee.domain.Employee;

/*Ա�������DAO�Ľӿ�*/
/*Ȼ����Ҫȥ��дdao��ʵ����*/
public interface EmployeeDao {
/*��DAO�ӿ��д�������*/
	Employee findByUsernameAndPassword(Employee employee);

}
