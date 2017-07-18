package com.ketan.hb.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publisher {	
	@Id  @GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	private String name;

	public Publisher() {}	
	public Publisher(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Publisher [code=" + code + ", name=" 
				+ name + "]";
	}	
}















