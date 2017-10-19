package com.es.employee.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.es.employee.dao.EmployeeDao;
import com.es.employee.domain.Employee;

/*Ա�������DAO��ʵ����*/
/*��Daoʵ�����У�dao�и����û����������ѯ�û��ķ���*/
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
	

	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		// TODO Auto-generated method stub
		String hql="from Employee where username=? and password=?";
		List<Employee> list=(List<Employee>) this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
		
	}

	



}
