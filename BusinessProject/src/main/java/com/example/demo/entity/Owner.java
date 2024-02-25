package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String type;
	private long mobile;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public Owner(int id, String name, String type, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.mobile = mobile;
	}
	public Owner() {
		super();
	}
	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", type=" + type + ", mobile=" + mobile + "]";
	}
   
	
}
