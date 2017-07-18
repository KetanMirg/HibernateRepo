package com.ketan.hb.pojos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/*Creating this class as Person class is very cluttered and there are many annotations to cover*/
/*Storing Collection as attribute of entity*/
/*Result - Since there is a Primary key in this entity, a new mapping table(PERSON_DETAILS_addresses i.e. <Entity name>_<collection_name>) is created by Hibernate that contains mapping between PERSON_DETAILS and addresses*/
/*IF we want to override the default name, use @JoinTable annotation - refer below example*/
@Entity(name="PERSON_DETAILS")
public class PersonDetails {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	// use the fetch parameter below only to do Eager Binding 
	@ElementCollection(fetch=FetchType.EAGER)//this tag is used for Saving the collection in the table
	@JoinTable(name="PERSON_ADDRESSES",joinColumns=@JoinColumn(name="PERSON_ADDRESS_ID"))
	@GenericGenerator(name="sequence-gen",strategy="sequence")
	@CollectionId(columns={@Column(name="ADDRESS_ID")},generator="sequence-gen",type=@Type(type="long"))
	//@JoinTable - This annotation is used for overriding the default names given by Hibernate to mapping table and columns
	//@JOinColumn -This annotation is required when we want to override the default name given by Hinernate to the mapping column 
	//@CollectionID - Important annotation - hibernate provided annotation, rest all are JPA provided. This is used for adding primary key to the collection that is added to the mapping table
	// For using CollectionId we have to use collection that has indexes, hence commenting hashset and changing to ArrayList
	// Important Note- For adding collection to the table, an Interface like set,Collection is always used as the declaration
	
	//private Set<Address> addresses = new HashSet<Address>();
	private Collection<Address> addresses = new ArrayList<Address>();
	
	
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
	public Collection<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	

}
