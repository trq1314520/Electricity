package com.es.electricity.service.impl;

import java.util.List;

import com.es.electricity.dao.ElectricityDao;
import com.es.electricity.domain.Electricity;
import com.es.electricity.service.ElectricityService;

public class ElectrictyServcieImpl implements ElectricityService {

	
	
private ElectricityDao electricityDao;
public void setElectricityDao(ElectricityDao electricityDao) {
	this.electricityDao = electricityDao;
}
@Override
public List<Electricity> findByElid(Integer eid) {
	// TODO Auto-generated method stub
	return electricityDao.findByElid(eid);
}

}
