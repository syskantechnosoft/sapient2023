package com.sapient.assessment1.model;

import java.sql.Date;
import java.util.Objects;

public class Employee {

	private int id;
	private String name;
	private String gender;
	private Date dob;
	private String email;
	private long mobile;

	public Employee() {
		super();
	}

	public Employee(int id, String name, String gender, Date dob, String email, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dob, email, gender, mobile, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && mobile == other.mobile
				&& Objects.equals(name, other.name);
	}

	
}
