package com.es.device.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.es.device.dao.DeviceDao;
import com.es.device.domain.Device;
import com.es.device.service.DeviceService;
import com.es.employee.domain.PageBean;
@Transactional

public class DeviceServiceImpl implements DeviceService {

	
	private DeviceService deviceService;

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
/*根据一级分类也就是实验室的lid带有分页查询商品*/
	@Override
	public PageBean<Device> findByPageLid(Integer lid, int currPage) {
		/*最终只需要返回一个PageBean就行了,所以创建出来一个对象,由于是刚创建出来的pageBean对象，所以里面并没有什么数据*/
		PageBean<Device> pageBean=new PageBean<Device>();
		pageBean.setCurrPage(currPage);//设置当前的页数到
		 int pageSize=15;
		 pageBean.setPageSize(pageSize);//设置每页显示的记录数
		 int totalCount=0;
		 totalCount=deviceDao.findCountLid(lid);
		 pageBean.setTotalCount(totalCount);
		 //设置总的页数
		 int totalPage=0;
		 if(totalCount%pageSize==0){
			 totalPage=totalCount/pageSize;
		 }else{
			 totalPage=totalCount/pageSize+1;
		 }
		 pageBean.setTotalPage(totalPage);
		 //每页显示的数据集合
		 int begin=(currPage-1)*pageSize;
		 List<Device> list=deviceDao.findByPageLid(lid,begin,pageSize);
		 pageBean.setList(list);
		return pageBean;
	}
	private DeviceDao deviceDao;

	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
	}
	

}
