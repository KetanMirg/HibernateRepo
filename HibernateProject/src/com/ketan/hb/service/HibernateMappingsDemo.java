package com.ketan.hb.service;

import java.util.List;

import com.ketan.hb.pojos.Book;
import com.ketan.hb.pojos.Chapter;
import com.ketan.hb.pojos.Publisher;

public class HibernateMappingsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LibraryService ls = new LibraryService();
		//onetoone
		Book b = new Book();
		//b.setIsbn("1234");
		b.setName("Java - Hibernate");


		Publisher pub = new Publisher();
		pub.setName("Ketan");


		b.setPublisher(pub);

		ls.savePublisher(pub);
		ls.saveBook(b);

		//onetomany
		
		Book b1 = new Book();
		//b.setIsbn("1234");
		b1.setName("Java - Spring");
		
		Chapter c1 = new Chapter();
		c1.setTitle("First Chapter");
		
		
		Chapter c2 = new Chapter();
		c2.setTitle("Second Chapter");
		
		
		Chapter c3 = new Chapter();
		c3.setTitle("Third Chapter");
		
		
		Chapter c4 = new Chapter();
		c4.setTitle("Fourth Chapter");
		
		
		
		
		b1.getChapters().add(c1);
		b1.getChapters().add(c2);
		b1.getChapters().add(c3);
		b1.getChapters().add(c4);
		//ls.saveBook(b1);
		
		c1.setBook(b1);
		c2.setBook(b1);
		c3.setBook(b1);
		c4.setBook(b1);
		//Enitites\Tables with relationship(inter-related updates) between them should be done in one Session\Transaction
		ls.saveBookAndChapter(b1, (List<Chapter>)b1.getChapters());
		
		
		//many to many mapping
		b1.getSmallChapters().add(c1);
		b1.getSmallChapters().add(c2);
		b1.getSmallChapters().add(c3);
		b1.getSmallChapters().add(c4);
		c1.getBooks().add(b1);
		c1.getBooks().add(b);
		c2.getBooks().add(b1);
		c2.getBooks().add(b);
		ls.saveBooksAndChapters((List<Book>)c1.getBooks(), (List<Chapter>)b1.getSmallChapters());
		
		
		


	}

}
