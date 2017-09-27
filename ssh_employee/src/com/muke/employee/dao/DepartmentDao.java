package com.muke.employee.dao;

import java.util.List;

import com.muke.employee.domain.Department;

/*部门管理的DAO层的接口*/
public interface DepartmentDao {

	List<Department> findByPage(int begin, int pageSize);

	int findCount();

	// 实现service的一种接口及方法
	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

}
