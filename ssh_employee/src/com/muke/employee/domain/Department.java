package com.muke.employee.domain;

import java.util.HashSet;
import java.util.Set;

/*�������ŵ�ʵ����*/
public class Department {
	/* ���ŵ�id */
	private Integer did;
	/* ���ŵ����� */
	private String dname;
	/* ���ŵ����� */
	private String ddesc;
	/*ÿ������������Ա���ļ���*/
	/*hibenate �е���Ĺ����ģ����д�������Ļ�������˫�����*/
	          /*Ա���ļ���    ���ϵ�����*/
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
