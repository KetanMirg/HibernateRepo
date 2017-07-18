package com.ketan.hb.pojos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/*********************************************NOTES**********************************************************************************************
 * Here 
 * OneToOne Mapping -   Book -> Publisher is a one to one mapping
 * OneToMany Mapping -  Book -> Chapter many to many mapping, collection is used as a declaration Always
 * 
 * There is one more way of doing one to many mapping and reverse mapping (many to one) using annotations @OneToMany (mapped by = book),
 *  where book is the attribute\member of Chapter entity
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */

@Entity
public class Book {
	@Id  @GeneratedValue(strategy=GenerationType.AUTO)
	private int isbn;
	private String name;
	@OneToOne
	private Publisher publisher;
	@OneToMany(mappedBy="book")
	/*@JoinTable(name="BOOK_CHAPTER_MAPPING",joinColumns={@JoinColumn(name="BOOK_ID")},inverseJoinColumns={@JoinColumn(name="CHAPTER_ID")})*/ //commenting to use another approach
	private Collection<Chapter> chapters = new ArrayList();
	
	@ManyToMany
	@JoinTable(name="BOOK_SMALLCHAPTER_MAPPING",joinColumns={@JoinColumn(name="BOOK_ID")},inverseJoinColumns={@JoinColumn(name="CHAPTER_ID")})
	private Collection<Chapter> smallChapters = new ArrayList();
	
	
	
	public Collection<Chapter> getSmallChapters() {
		return smallChapters;
	}
	public void setSmallChapters(Collection<Chapter> smallChapters) {
		this.smallChapters = smallChapters;
	}
	public Book() {}
	public Book(int isbn, String name, Publisher publisher) {
		this.isbn = isbn;
		this.name = name;
		this.publisher = publisher;
	}

	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	/*public List getChapters() {
		return chapters;
	}
	public void setChapters(List chapters) {
		this.chapters = chapters;
	}*/
	
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", publisher="
				+ publisher + ", chapters=]";
	}
	public Collection<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(Collection<Chapter> chapters) {
		this.chapters = chapters;
	}
}

