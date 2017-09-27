package com.muke.employee.dao;

import java.util.List;

import com.muke.employee.domain.Department;

/*���Ź����DAO��Ľӿ�*/
public interface DepartmentDao {

	List<Department> findByPage(int begin, int pageSize);

	int findCount();

	// ʵ��service��һ�ֽӿڼ�����
	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

}
