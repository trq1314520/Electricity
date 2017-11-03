package com.es.electricity.dao;

import java.util.List;

import com.es.electricity.domain.Electricity;

public interface ElectricityDao {

	List<Electricity> findByElid(Integer eid);

	

}
