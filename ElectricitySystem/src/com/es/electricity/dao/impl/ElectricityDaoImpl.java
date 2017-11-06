package com.es.electricity.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.es.electricity.dao.ElectricityDao;
import com.es.electricity.domain.Electricity;

/**
 * @author 田瑞清
 *@time 2017.11.1
 */
public class ElectricityDaoImpl extends HibernateDaoSupport implements ElectricityDao {
	/*
	 *根据设备id查询电流值的id的方法 
	 * 
	 */

	@Override
	public List<Electricity> findByElid(Integer eid) {
		String hql="select e from Electricity e join e.device d where d.eid=?";
		List<Electricity> list= (List<Electricity>) this.getHibernateTemplate().find(hql, eid);
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
		
	}

}
