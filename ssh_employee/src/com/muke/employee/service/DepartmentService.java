package com.muke.employee.service;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;

/*���Ź����service��Ľӿ�*/
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	// ��ҵ��������һ��δʵ�ֵ��༰����
	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

}
