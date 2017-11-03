package com.es.electricity.domain;

import java.util.Date;

import com.es.device.domain.Device;

public class Electricity {
private Integer elid;
private Double elvalue;
private Date eltime;
private Date elstarttime;
private Date elendtime;
/*一对一外键*/
private Device device;

public Device getDevice() {
	return device;
}
public void setDevice(Device device) {
	this.device = device;
}
public Integer getElid() {
	return elid;
}
public void setElid(Integer elid) {
	this.elid = elid;
}
public Double getElvalue() {
	return elvalue;
}
public void setElvalue(Double elvalue) {
	this.elvalue = elvalue;
}
public Date getEltime() {
	return eltime;
}
public void setEltime(Date eltime) {
	this.eltime = eltime;
}
public Date getElstarttime() {
	return elstarttime;
}
public void setElstarttime(Date elstarttime) {
	this.elstarttime = elstarttime;
}
public Date getElendtime() {
	return elendtime;
}
public void setElendtime(Date elendtime) {
	this.elendtime = elendtime;
}

}
