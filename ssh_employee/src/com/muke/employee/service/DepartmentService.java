package com.muke.employee.service;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;

/*部门管理的service层的接口*/
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	// 在业务层中添加一个未实现的类及方法
	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

}
