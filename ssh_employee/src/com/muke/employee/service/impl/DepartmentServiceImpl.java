package com.muke.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;

/*���Ź����һ��ҵ����ʵ����*/
public class DepartmentServiceImpl implements DepartmentService {
	// ע�벿�Ź����DAO,Ȼ����application.xml�н�daoע�뵽����
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	// ��ҳ��ѯ���ŵķ���
	public PageBean<Department> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Department> pageBean = new PageBean<Department>();
		// ��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		// ��װÿҳ��ʾ��¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		// ��װ�ܼ�¼��
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		// ��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// ��װÿҳ��ʾ������
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	// ҵ�������Ҫʵ��һ������Ĺ���
	// ʵ��ҵ�����е�һ�ַ���
	@Transactional
	@Override
	//ҵ����б���һ�����ŵķ���
	public void save(Department department) {
		departmentDao.save(department);

	}
/*//���ݲ���id�����Ҳ��ŵ�һ�ַ���
*/
	@Override
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}

	@Override
	public void update(Department department) {
		departmentDao.update(department);
		
	}

	@Override
	public void delete(Department department) {
		departmentDao.delete(department);
		
	}

}
