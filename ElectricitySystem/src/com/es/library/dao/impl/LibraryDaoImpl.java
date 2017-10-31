package com.es.library.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.es.library.dao.LibraryDao;
import com.es.library.domain.Library;

public class LibraryDaoImpl extends HibernateDaoSupport implements LibraryDao {
	//dao中查询所有实验室标号
		public List<Library> findLibAll() {
			String hql="from Library";
			List<Library> list=(List<Library>) this.getHibernateTemplate().find(hql);
			return list;
		}

}
