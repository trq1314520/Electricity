package com.muke.employee.service.impl;
import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.domain.Employee;
/*业务层需要去调用dao层*/
import com.muke.employee.service.EmployeeService;
/*员工管理的业务层的实现类*/
/*实现的功能是action去调用service层，service去调用dao层，然后去完成数据库的一个查询操作*/
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

}
