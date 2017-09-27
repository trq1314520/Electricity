package com.muke.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;
/*部门管理的DAO的实现类*/
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public List<Department> findByPage(int begin, int pageSize) {
	//分页查询部门
		DetachedCriteria criteria=DetachedCriteria.forClass(Department.class);
		List<Department> list=(List<Department>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		/*统计个数*/
		String hql="select count(*) from Department";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	//dao中保存部门的方法
	public void save(Department department) {
	//使用模版去保存save的方法
		this.getHibernateTemplate().save(department);
		
	}
//通过id查询相应的方法。。。dao中根据部门的ID查询部门的方法
	@Override
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Department.class, did);
	}
/*dao 中修改部门的方法*/
	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
		
	}

	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
		
	}

}
