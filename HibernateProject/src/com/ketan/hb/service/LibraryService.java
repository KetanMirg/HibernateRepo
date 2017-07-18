package com.ketan.hb.service;

import java.util.List;

import com.ketan.hb.dao.LibraryDAO;
import com.ketan.hb.daoimpl.LibraryDAOImpl;
import com.ketan.hb.pojos.Book;
import com.ketan.hb.pojos.Chapter;
import com.ketan.hb.pojos.Person;
import com.ketan.hb.pojos.PersonDetails;
import com.ketan.hb.pojos.Publisher;

public class LibraryService {

	LibraryDAO dao;
	public LibraryService() {
		// TODO Auto-generated constructor stub
		dao = new LibraryDAOImpl();
	}
	public void saveBook(Book b){
		dao.saveBook(b);
	}

	public void savePerson(Person p){
		dao.savePerson(p);	
	}

	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		return dao.getPerson(id);
	}

	public void savePersonDetails(PersonDetails p){
		dao.savePersonDetails(p);	
	}

	public PersonDetails getPersonDetails(int id){
		return dao.getPersonDetails(id);
	}

	public void savePublisher(Publisher pub) {
		dao.savePublisher(pub);

	}
	
	public void saveChapter(Chapter c){
		dao.saveChapter(c);	
	}
	public void saveBookAndChapter(Book b, List<Chapter>c){
		dao.saveBookAndChapter(b,c);	
	}
	
	public void saveBooksAndChapters(List<Book> b, List<Chapter>c){
		dao.saveBooksAndChapters(b,c);	
	}

}
