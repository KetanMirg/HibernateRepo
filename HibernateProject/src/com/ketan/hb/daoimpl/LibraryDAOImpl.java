package com.ketan.hb.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ketan.hb.dao.LibraryDAO;
import com.ketan.hb.pojos.Book;
import com.ketan.hb.pojos.Chapter;
import com.ketan.hb.pojos.Person;
import com.ketan.hb.pojos.PersonDetails;
import com.ketan.hb.pojos.Publisher;

public class LibraryDAOImpl implements LibraryDAO{

	SessionFactory sessionFactory = null;
	public LibraryDAOImpl() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		// TODO Auto-generated constructor stub


	}
	public void saveBook(Book b) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction trans = session.getTransaction();
		trans.begin();
		session.save(b);
		trans.commit();
		session.close();

	}

	public void getBook(String isbn) {
		// TODO Auto-generated method stub

	}

	public void getChapters(String isbn) {
		// TODO Auto-generated method stub

	}

	public void getPublisher(String isbn) {
		// TODO Auto-generated method stub

	}
	public void savePerson(Person b) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction trans = session.getTransaction();
		trans.begin();
		session.save(b);
		trans.commit();
		session.close();

	}
	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction trans = session.getTransaction();
		trans.begin();
		Person per = session.get(Person.class,id);
		trans.commit();
		session.close();
		return per;
	}
	public void savePersonDetails(PersonDetails b) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction trans = session.getTransaction();
		trans.begin();
		session.save(b);
		trans.commit();
		session.close();

	}
	public PersonDetails getPersonDetails(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction trans = session.getTransaction();
		trans.begin();
		PersonDetails pd = session.get(PersonDetails.class,id);
		trans.commit();
		session.close();
		return pd;
	}
	public void savePublisher(Publisher pub) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction trans = session.getTransaction();
		trans.begin();
		session.save(pub);
		trans.commit();
		session.close();

	}
	public void saveChapter(Chapter c) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction trans = session.getTransaction();
		trans.begin();
		session.save(c);
		trans.commit();
		session.close();

	}
	public void getChapters(int isbn) {
		// TODO Auto-generated method stub

	}
	public void saveBookAndChapter(Book b, List<Chapter> c) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction trans = session.getTransaction();
		trans.begin();
		session.save(b);
		for(Chapter c1 : c){
			session.save(c1);
		}
		trans.commit();
		session.close();

	}
	public void saveBooksAndChapters(List<Book> b, List<Chapter> c) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction trans = session.getTransaction();
		trans.begin();
		for(Book b1 : b){
			session.save(b1);
		}
		for(Chapter c1 : c){
			session.save(c1);
		}
		trans.commit();
		session.close();

	}




}
