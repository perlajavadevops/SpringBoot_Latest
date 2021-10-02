package com.pgr.sb.jdbc.bean;

public class Employee {

	private int empno;
	private String name;
	private double salary;

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + "]";
	}

	public Employee(int empno, String name, double salary) {
		super();
		this.empno = empno;
		this.name = name;
		this.salary = salary;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void displayEmployee() {
		System.out.println("Employee Details are: ");
		System.out.println(empno);
		System.out.println(name);
		System.out.println(salary);
	}

}
