package com.es.library.domain;

import java.util.HashSet;
import java.util.Set;

import com.es.device.domain.Device;

/**
 * @author 田瑞清
 *
 */
//创建实验室实体类对象
public class Library {
private Integer lid;
private String lname;
private String location;
//实验室属于一方，设备属于多方，一方含有多方的集合
private Set<Device> devices=new HashSet<Device>();
//创建实体类的属性的get和set方法

public Integer getLid() {
	return lid;
}
public Set<Device> getDevices() {
	return devices;
}
public void setDevices(Set<Device> devices) {
	this.devices = devices;
}
public void setLid(Integer lid) {
	this.lid = lid;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}

}
