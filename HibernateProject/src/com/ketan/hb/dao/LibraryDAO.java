package com.ketan.hb.dao;

import java.util.List;

import com.ketan.hb.pojos.Book;
import com.ketan.hb.pojos.Chapter;
import com.ketan.hb.pojos.Person;
import com.ketan.hb.pojos.PersonDetails;
import com.ketan.hb.pojos.Publisher;

public interface LibraryDAO {
	public void saveBook(Book b);
	public void savePerson(Person b);
	public void saveChapter(Chapter c);
	public void getBook(String isbn);
	public void getChapters(int isbn);
	public void getPublisher(String isbn);
	public void savePublisher(Publisher pub);
	public Person getPerson(int id);
	public void savePersonDetails(PersonDetails b);
	public PersonDetails getPersonDetails(int id);
	public void saveBookAndChapter(Book b, List<Chapter> c);
	public void saveBooksAndChapters(List<Book> b, List<Chapter> c);
	
	

}
