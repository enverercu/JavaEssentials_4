package Spring.Hibernate;

public class Batch {

	//Consider a situation when you need to upload a large number of records into your database using Hibernate. 

	Session session = SessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	for ( int i=0; i<100000; i++ ) {
	   Employee employee = new Employee(.....);
	   session.save(employee);
	}
	tx.commit();
	session.close();
	
//	By default, Hibernate will cache all the persisted objects 
//	in the session-level cache and ultimately your application would fall over with an OutOfMemoryException 
//	somewhere around the 50,000th row. 
//	You can resolve this problem, if you are using batch processing with Hibernate.

//	To use the batch processing feature, first set hibernate.jdbc.batch_size 
//	as batch size to a number either at 20 or 50 depending on object size

	Session session = SessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	for ( int i=0; i<100000; i++ ) {
	   Employee employee = new Employee(.....);
	   session.save(employee);
	   if( i % 50 == 0 ) { // Same as the JDBC batch size
	      //flush a batch of inserts and release memory:
	      session.flush();
	      session.clear();
	   }
	}
	tx.commit();
	session.close();
	
	

}

