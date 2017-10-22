package com.es.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.es.employee.dao.EmployeeDao;
import com.es.employee.domain.Employee;

/*员工管理的DAO的实现类*/
/*在Dao实现类中，dao中根据用户名和密码查询用户的方法*/
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

	@Override
	public int findCount() {
		String hql="select count(*) from Employee";//得到用户的个数
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();//将长整型变成int返回
		}
		
		return 0;
	}
     //分页查询用户
	@Override
	public List<Employee> findByPage(int begin, int pageSize) {//离线查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Employee.class);
		List<Employee> list=(List<Employee>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
     //dao中根据用户的id查询用户的方法
	@Override
	public Employee findById(Integer eid) {
		
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
		
	}

	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
		
	}

	



}
