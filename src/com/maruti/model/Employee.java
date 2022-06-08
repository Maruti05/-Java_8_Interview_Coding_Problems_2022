package com.maruti.model;

public class Employee {
	private int empId;
	private String empName;
	private int deptId;
	private double salary;
	private boolean isActive;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Employee(int empId, String empName, int deptId, double salary, boolean isActive) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptId = deptId;
		this.salary = salary;
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", deptId=" + deptId + ", salary=" + salary
				+ ", isActive=" + isActive + "]";
	}
	
}
