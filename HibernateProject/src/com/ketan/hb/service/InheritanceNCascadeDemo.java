package com.ketan.hb.service;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ketan.hb.pojos.FourWheeler;
import com.ketan.hb.pojos.TwoWheeler;
import com.ketan.hb.pojos.UserDetails;
import com.ketan.hb.pojos.Vehicle;


//This sample shows the cascading capability of Hibernate 
// Description:- There is a one to many relation between User and Vehicle. If we just save user entity(using session.persist()) vehicles will be saved 
// by themselves due to cascade feature of hibernate
public class InheritanceNCascadeDemo {
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	public static void main(String[] args) {
		//CAscade Example
		UserDetails ud = new UserDetails();
		ud.setName("Ketan");
		Collection<Vehicle> vehilesList = new ArrayList<Vehicle>();
		Vehicle v1 = new Vehicle();
		v1.setName("car");
		Vehicle v2 = new Vehicle();
		v2.setName("byke");
		Vehicle v3 = new Vehicle();
		v3.setName("cycle");
		Vehicle v4 = new Vehicle();
		v4.setName("bus");
		vehilesList.add(v1);
		vehilesList.add(v2);
		vehilesList.add(v3);
		vehilesList.add(v4);
		ud.setVehicles(vehilesList);
		//cascadeExample(ud);
		
		inheritanceExample();
		
	}
	
	
	public static void cascadeExample(UserDetails ud){
		
		Session session = sessionFactory.openSession();
		Transaction trans = session.getTransaction();
		trans.begin();
		//saving only UserDetails object that would cascade the save of Vehicle Object
		session.persist(ud);
		trans.commit();
		session.close();
	}
	public static void inheritanceExample(){
		Vehicle v = new Vehicle();
		v.setName("car");
		
		TwoWheeler tw = new TwoWheeler();
		tw.setSteeringHandle("bike");
		
		FourWheeler fw = new FourWheeler();
		fw.setSteeringWheel("Tiago");
		
		Session session = sessionFactory.openSession();
		Transaction trans = session.getTransaction();
		trans.begin();
		//saving only UserDetails object that would cascade the save of Vehicle Object
		session.save(v);
		session.save(tw);
		session.save(fw);
		trans.commit();
		session.close();
		
	};
}

