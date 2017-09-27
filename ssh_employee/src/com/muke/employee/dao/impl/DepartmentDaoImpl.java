package com.muke.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;
/*���Ź����DAO��ʵ����*/
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public List<Department> findByPage(int begin, int pageSize) {
	//��ҳ��ѯ����
		DetachedCriteria criteria=DetachedCriteria.forClass(Department.class);
		List<Department> list=(List<Department>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		/*ͳ�Ƹ���*/
		String hql="select count(*) from Department";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	//dao�б��沿�ŵķ���
	public void save(Department department) {
	//ʹ��ģ��ȥ����save�ķ���
		this.getHibernateTemplate().save(department);
		
	}
//ͨ��id��ѯ��Ӧ�ķ���������dao�и��ݲ��ŵ�ID��ѯ���ŵķ���
	@Override
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Department.class, did);
	}
/*dao ���޸Ĳ��ŵķ���*/
	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
		
	}

	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
		
	}

}
