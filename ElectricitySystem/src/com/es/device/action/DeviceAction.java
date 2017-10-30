package com.es.device.action;

import com.es.device.domain.Device;
import com.es.device.service.DeviceService;
import com.es.employee.domain.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeviceAction extends ActionSupport implements ModelDriven<Device> {
	//模型驱动接收lid，由于是接收device的，但是设备和和实验室是存在一对多的关系，所以也是可以接收到的
/*	也可以自己定义一个接收
	private Integer lid;
	接收lid；然后查询所有的一级和多级
	public void setLid(Integer lid) {
		this.lid = lid;
	}*/
	private Integer lid;
	
	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	private Device device = new Device();
	@Override
	public Device getModel() {
		return device;
	}
	
	/*lid已经接收了，还需要接收当前的页数*/
private int currPage;
	public void setCurrPage(int currPage) {
	this.currPage = currPage;
}

	/*由于以及分类已经在library中被查询出来了所有有关的的数据放在session中，由于session中数据不会缺失，所以直接可以去获取*/
	/*查询出来的结果返回PageBean就可以了，因为它里面含有所有这些的集合*/
	public String findByLid(){
		/*页面中获取到数据*/
		PageBean<Device> pageBean= deviceService.findByPageLid(lid,currPage);//根据以及分类也就是实验室查询设备
		//将PageBean存入到值栈中去
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByDid";
	}
	/*注入deviceService，获取deviceService的对象*/
	private DeviceService deviceService;
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
	
}
