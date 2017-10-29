package com.es.library.domain;

/**
 * @author 田瑞清
 *
 */
//创建实验室实体类对象
public class Library {
private Integer lid;
private String lname;
private String location;
//创建实体类的属性的get和set方法
public Integer getLid() {
	return lid;
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
