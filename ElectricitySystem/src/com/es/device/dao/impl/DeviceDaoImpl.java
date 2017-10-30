package com.es.device.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.es.device.dao.DeviceDao;
import com.es.device.domain.Device;
import com.es.utils.PageHibernateCallback;

public class DeviceDaoImpl extends HibernateDaoSupport implements DeviceDao {

	@Override
	public int findCountLid(Integer lid) {
		String hql="select count(*) from Device d where d.library.lid=?";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql, lid);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Device> findByPageLid(Integer lid, int begin, int pageSize) {
		String hql="select d from Device d join d.library l where l.lid=?";
		List<Device> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Device>(hql,new Object[]{lid},begin,pageSize));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

}
