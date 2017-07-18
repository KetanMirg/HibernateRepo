package com.ketan.hb.pojos;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

// BookToChapter -> one to many
// Book is attribute to chapter as well which is Many to one REVERSE RELATIONSHIP 


@Entity
public class Chapter {
	private String title;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int chapterNumber;
	
	@ManyToOne
	@JoinColumn(name="BOOK_ID") //another way of achieving one to many and many to one relationship
	private Book book;
	
	
	
	@ManyToMany
	private Collection<Book> books = new ArrayList();
	
	public Collection<Book> getBooks() {
		return books;
	}
	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
	public Chapter() {}	
	public Chapter(String title, int chapterNumber) {
		this.title = title;
		this.chapterNumber = chapterNumber;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getChapterNumber() {
		return chapterNumber;
	}
	public void setChapterNumber(int chapterNumber) {
		this.chapterNumber = chapterNumber;
	}
	
	public String toString() {
		return "Chapter [title=" + title + ", chapterNumber=" 
				+ chapterNumber + "]";
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}	
}