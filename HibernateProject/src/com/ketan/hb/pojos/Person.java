package com.ketan.hb.pojos;



import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/*Important Notes*/
// Value Object -  An object can be a part of the class eg-  An address can be an object with attrs street, city, state, pincode below is the example
// Embedded object - This is logical that address itself is not an Entity (logically)  as it does not exist alone and contributes to Person
// Entity Object - An entity or pojo is something that has a distinct, separate existence eg- Person
//Entity meaning in terms of hibernate - An entity or pojo is something that has a distinct, separate existence.
//@Transient annotaion = hibernate do not persist transient marked fields or static variables of a class i.e. table will not have any column for them
@Entity (name="Person")   //if table name is to be different than the class name we can use name attribute, by using this we actually rename the entity
//@Table (name="person_table") //either table or entity can be used , by using this we refer to the table by person_table but entity name remains the same

public class Person {

	//Primary Keys - 1) Natural Key - A column that already exists in the table and has business significance eg- email id that is mandatory can be marked as Primary Key or Natural Key 
	// - 2) Surrogate Key - A column that is deliberately added for the purpose of making it as a primary key of the table

	@Id @GeneratedValue(strategy=GenerationType.AUTO) // Surrogate key - We leave it to hibernate to generate key values, where strategy is optional and is a way of telling hibernate how to create\generate\increment Primary key values
	@Column(name="id") // if name of the column is different than the attribute of the class
	private int id;
	//@Basic(optional=true)  // basic used without parameter is as good as not having any property used for configuration
	// when optional is true makes this field as optional
	
	
	private String name;


	@Column(name="address")
	@Embedded // This annotation is added to have address object as 4 columns added to the same table, than to have a separate table in DB
	private Address homeAddress;


	
	//If there are multiple embedded attributes like homeAddress and officeAddress both of same type(Address), then we have to override the attributes using AttributeOverrides
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="HOME_STREET_NAME")),
		@AttributeOverride(name="city",column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride(name="state",column=@Column(name="HOME_STATE_NAME")),
		@AttributeOverride(name="pincode",column=@Column(name="HOME_PIN_CODE")),
	})
	private Address officeAddress;


	@Temporal(TemporalType.DATE)  //@TemporalType.DATE would only insert date and skip timestamp and milli seconds
	private Date dob;
	
	
	
	@Lob          // by default varchar size created by Hibernate is 255, but if there is a large text to be inserted to the table lob annotation is used
	//String =  lob is treated as clob
	//byte []  =  lob is treated as blob
	private String description;
	
	
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
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
	public Address getHomeAddress() {
		return homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
