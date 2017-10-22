package com.es.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.es.employee.domain.Employee;
import com.es.employee.domain.PageBean;
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
@Override
//分页查询的方法
public PageBean<Employee> findByPage(Integer currPage) {
	PageBean<Employee> pageBean=new PageBean<Employee>();
	//pagebean数据的封装
	//封装当前的页数
	pageBean.setCurrPage(currPage);//当前的页数是从外界传过来的
	//封装每页显示的记录数,也就是设置pageBean页实体页中的PageSize
	int pageSize=3;
	pageBean.setPageSize(pageSize);
	//封装总的记录数
	//先查询记录数在Dao层，即持久层
	int totalCount=employeeDao.findCount();
	pageBean.setTotalCount(totalCount);
	//封装总页数，一般是总记录数除以每页的记录数
	double tc=totalCount;//先int转化为double类型
	Double num=Math.ceil(tc/pageSize);//相除之后取整
	pageBean.setTotalPage(num.intValue());//封装总页数，然后将double类型转化为int类型
	//封装每页显示的数据：
	int begin=(currPage-1)*pageSize;
	List<Employee> list=employeeDao.findByPage(begin,pageSize);//先在数据库中查询所有的数据以及页数
	pageBean.setList(list);//
	return pageBean;
}
@Override
//业务层根据用户的id查询用户的方法
public Employee findById(Integer eid) {
	
	return employeeDao.findById(eid);
}
@Transactional
@Override
public void update(Employee employee) {
	employeeDao.update(employee);
	
}
@Transactional
@Override
public void delete(Employee employee) {
	employeeDao.delete(employee);
	
}

}

