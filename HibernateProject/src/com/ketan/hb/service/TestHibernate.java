package com.ketan.hb.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.ketan.hb.pojos.Address;
import com.ketan.hb.pojos.Person;
import com.ketan.hb.pojos.PersonDetails;

/**
 * @author Ketan
 *
 */
public class TestHibernate {

	
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "HR";
	private static final String DB_PASSWORD = "radhasoami";
	private static final DateFormat dateFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LibraryService service = new LibraryService();
		// Embedded object as Address
		Address addr = new Address();
		addr.setCity("Meerut");
		addr.setPincode("250001");
		addr.setState("Uttar Pradesh");
		addr.setStreet("Telephone Exchange");
		Address addr2 = new Address();
		addr2.setCity("Noida");
		addr2.setPincode("201301");
		addr2.setState("Uttar Pradesh");
		addr2.setStreet("Sector 76");
		Person p = new Person();
		p.setHomeAddress(addr);
		p.setOfficeAddress(addr);
		p.setId(1);
		p.setName("ketan");
		p.setDob(new Date());
		service.savePerson(p);
		p = new Person();
		p.setHomeAddress(addr);
		p.setOfficeAddress(addr);
		p.setId(2);
		p.setName("Sanchit");
		p.setDob(new Date());
		service.savePerson(p);
		
		
		//getting object from DB
		p = service.getPerson(2);
		System.out.println("Person:-"+p.getName());
		
		//Saving Collections to DB example
		//Set<Address> addresses = new HashSet();
		Collection<Address> addresses = new ArrayList();
		addresses.add(addr);
		addresses.add(addr2);
		
		PersonDetails pd = new PersonDetails();
		pd.setName("Ketan");
		pd.setAddresses(addresses);
		
		service.savePersonDetails(pd);
		
		
		/*try {
			insertRecordIntoDbUserTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Very Important Concept - Eager Lazy Binding and Proxy Classes Explanation
		demoEagerLazyBinding(service);
		

	}
	
	private static void demoEagerLazyBinding(LibraryService service){
		PersonDetails pd = service.getPersonDetails(1);
		//Below details are fetched as soon as session.get(EAGERLY) is done (Refer DAO for the same)
		System.out.println("Person Details:-"
				+ "Name:"+pd.getName() + "Id:"+pd.getId());
		
		// But as soon as we try to retrieve addresses, since its a collection, in order to improve performance hibernate
		// makes a late call again to the database as soon as we try to retrieve pd.getAddresses() eg below would give null pointer as session was 
		// closed in DAO just after fetching the other details using Proxy.. To eagerly fetch refer PersonDetails class
		pd.getAddresses();
		System.out.println("Addresses size:-"+pd.getAddresses().size());
		
		
	}
	
	private static void insertRecordIntoDbUserTable() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		String insertTableSQL = "INSERT INTO employees"
				+ "(employee_id, first_name, last_name, salary,email, department_id,hire_date,job_id) " + "VALUES"
				+ "(1,'ketan','mirg',93000,'gmail',90,'17-JUN-87','AD_VP')";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(insertTableSQL);

			// execute insert SQL stetement
			statement.executeUpdate(insertTableSQL);

			System.out.println("Record is inserted into DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
                               DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}
	
	private static String getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return dateFormat.format(today.getTime());

	}

}
