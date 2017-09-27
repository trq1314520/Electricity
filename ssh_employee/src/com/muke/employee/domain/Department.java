package com.muke.employee.domain;

import java.util.HashSet;
import java.util.Set;

/*创建部门的实体类*/
public class Department {
	/* 部门的id */
	private Integer did;
	/* 部门的名称 */
	private String dname;
	/* 部门的描述 */
	private String ddesc;
	/*每个部门所属的员工的集合*/
	/*hibenate 有单项的关联的，如果写了两个的话，就是双向关联*/
	          /*员工的集合    集合的名称*/
	private  Set<Employee> employees = new HashSet<Employee>();
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDdesc() {
		return ddesc;
	}
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}

}
