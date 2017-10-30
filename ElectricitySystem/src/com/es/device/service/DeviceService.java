package com.es.device.service;

import com.es.device.domain.Device;
import com.es.employee.domain.PageBean;

public interface DeviceService {

	PageBean<Device> findByPageLid(Integer lid, int currPage);

}
