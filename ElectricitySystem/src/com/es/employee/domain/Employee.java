package com.es.employee.domain;



public class Employee {
	private Integer eid;
	private String username;
	private String password;
	private String customerType;
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
