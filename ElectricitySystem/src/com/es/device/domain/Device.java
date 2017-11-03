package com.es.device.domain;

import java.util.Date;

import com.es.electricity.domain.Electricity;
import com.es.library.domain.Library;

public class Device {
private Integer eid;
private String ename;
private String eaddress;
private Date einputtime;
private String eimagepath;
private String edesc;
private Integer estate;

private Electricity electricity;

public Electricity getElectricity() {
	return electricity;
}
public void setElectricity(Electricity electricity) {
	this.electricity = electricity;
}
//实验室的外键，由于hibernate不能建外键，只能建对象,使用一级分类的对象,也就是多的含有少的对象，少的含有多的集合
//实验室对象
private Library library;

public Library getLibrary() {
	return library;
}
public void setLibrary(Library library) {
	this.library = library;
}
public Integer getEid() {
	return eid;
}
public void setEid(Integer eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getEaddress() {
	return eaddress;
}
public void setEaddress(String eaddress) {
	this.eaddress = eaddress;
}
public Date getEinputtime() {
	return einputtime;
}
public void setEinputtime(Date einputtime) {
	this.einputtime = einputtime;
}
public String getEimagepath() {
	return eimagepath;
}
public void setEimagepath(String eimagepath) {
	this.eimagepath = eimagepath;
}
public String getEdesc() {
	return edesc;
}
public void setEdesc(String edesc) {
	this.edesc = edesc;
}
public Integer getEstate() {
	return estate;
}
public void setEstate(Integer estate) {
	this.estate = estate;
}



}
