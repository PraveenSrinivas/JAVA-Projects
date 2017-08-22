package com.jdbc.employee;

public class EmployeeBean {
	private String name,designation;
	private long salary;
	int eid;
	public String getName() {
		return name;
	}
	public String getDesignation() {
		return designation;
	}
	public long getSalary() {
		return salary;
	}
	public int getEid() {
		return eid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}


	@Override
	public String toString() {
		return "EmployeeBean[name ="+name+"eid ="+eid+"salary="+salary+"designation="+designation+"]";
	}

}
