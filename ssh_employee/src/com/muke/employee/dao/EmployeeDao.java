package com.muke.employee.dao;

import com.muke.employee.domain.Employee;

/*员工管理的DAO的接口*/
/*然后需要去编写dao的实现类*/
public interface EmployeeDao {
/*在DAO接口中创建方法*/
	Employee findByUsernameAndPassword(Employee employee);

}
