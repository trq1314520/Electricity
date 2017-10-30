package com.es.device.dao;

import java.util.List;

import com.es.device.domain.Device;

public interface DeviceDao {

	int findCountLid(Integer lid);

	List<Device> findByPageLid(Integer lid, int begin, int pageSize);

}
