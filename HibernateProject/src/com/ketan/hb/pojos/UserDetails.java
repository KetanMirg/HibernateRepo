package com.ketan.hb.pojos;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class UserDetails {
	
	@Id @GeneratedValue
	private int userId;
	private String name;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="USER_VEHICLE_MAP",joinColumns={@JoinColumn(name="VEHICLE_ID")})
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	
	
}
