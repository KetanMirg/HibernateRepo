package com.ketan.hb.pojos;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


/*Note:-
 * 
 * Strategies for Inheritance could be of 3 types;
 * 1) Single Table   -  All the data is maintained in the same table. Least Normalised.This keeps on adding column for each new attribute for all the subclasses of the vehicle
 * 2) Table Per Class - There exists one table for each entity - Here total 3 tables one each for Vehicle, TwoWheeler and FourWheeler . Here all the parent data is made available in the sub class or child tables. - More Normalised
 * 3) Joined Strategy -  Most normalised.There exists one table for each entity - Here total 3 tables one each for Vehicle, TwoWheeler and FourWheeler. Parent data does not flow in the child tables.
 * 
 * */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="VEHICLE_ID",discriminatorType=DiscriminatorType.STRING)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle {
	
	@Id @GeneratedValue
	private int id;
	private String name;
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
	
}
