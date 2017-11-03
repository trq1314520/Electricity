package com.es.electricity.action;

import java.util.List;

import com.es.electricity.domain.Electricity;
import com.es.electricity.service.ElectricityService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ElectricityAction extends ActionSupport implements ModelDriven<Electricity> {
	private Electricity electricity = new Electricity();
	@Override
	public Electricity getModel() {

		return electricity;
	}
	private Integer eid;
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String findByElid(){
		List<Electricity> list=electricityService.findByElid(eid);
		ActionContext.getContext().getValueStack().set("list", list);
		return "findByElid";
	}
	private ElectricityService electricityService;
	public void setElectricityService(ElectricityService electricityService) {
		this.electricityService = electricityService;
	}
	
}
