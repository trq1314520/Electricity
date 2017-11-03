package com.es.electricity.service;

import java.util.List;

import com.es.electricity.domain.Electricity;

public interface ElectricityService {

	List<Electricity> findByElid(Integer eid);



}
