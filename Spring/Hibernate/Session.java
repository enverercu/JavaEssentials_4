package Spring.Hibernate;

public class Session {

	Session session = factory.openSession();
	Transaction tx = null;

	try {
	   tx = session.beginTransaction();
	   // do some work
	   ...
	   tx.commit();
	}

	catch (Exception e) {
	   if (tx!=null) tx.rollback();
	   e.printStackTrace(); 
	} finally {
	   session.close();
	}
}
