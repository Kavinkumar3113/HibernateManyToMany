package com.ManyToMany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Student {
	@Id
	private int sid;
	private String sname;
	@ManyToMany(mappedBy = "stud")
	private List<Laptop> lap;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public List<Laptop> getLaptop() {
		return lap;
	}
	public void setLaptop(List<Laptop> lap) {
		this.lap = lap;
	}
	
	

}
