package com.nagarro.hrmanager.model;

public class Employee {
	

	private int ecode;
	private String name;
	private String loc;
	private String email;
	private String dob;
	
	public Employee() {
		
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [ecode=" + ecode + ", name=" + name + ", loc=" + loc + ", email=" + email + ", dob=" + dob
				+ "]";
	}



	public Employee(String name, String loc, 
			String email, String dob) {
		this.name = name;
		this.loc = loc;
		this.email = email;
		this.dob = dob;
	}
	
	
	
	public int getEcode() {
		return ecode;
	}
	public String getName() {
		return name;
	}
	public String getLoc() {
		return loc;
	}
	public String getEmail() {
		return email;
	}
	public String getDob() {
		return dob;
	}
	public void setEcode(int ecode) {
		this.ecode = ecode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
}
