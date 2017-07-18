package com.ketan.hb.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.ketan.hb.pojos.UserDetails;

public class CriteriaDemo {
	
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	public static void main(String[] args) {
		addSomeUsers();
		criteriaExample();
	}
	
	
public static void criteriaExample(){
		
		Session session = sessionFactory.openSession();
		Transaction trans = session.getTransaction();
		trans.begin();
		//saving only UserDetails object that would cascade the save of Vehicle Object
		Criteria crit = session.createCriteria(UserDetails.class);
		crit.add(Restrictions.eq("name", "user 1"));
		List<UserDetails> usersList = crit.list();
		for(UserDetails u : usersList){
			System.out.println("Users - "+u.getName());
		}
		//session.persist(ud);
		trans.commit();
		session.close();
	}


public static void addSomeUsers(){
	Session session = sessionFactory.openSession();
	Transaction trans = session.getTransaction();
	trans.begin();
	UserDetails ud = null;
	for ( int i=0; i< 10; i++){
		ud = new UserDetails();
		ud.setName("user "+i);
		session.save(ud);
	}
	
	trans.commit();
	session.close();
}

}
