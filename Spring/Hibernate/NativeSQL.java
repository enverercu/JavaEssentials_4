package Spring.Hibernate;

public class NativeSQL {

	String sql = "SELECT first_name, salary FROM EMPLOYEE";
	SQLQuery query = session.createSQLQuery(sql);
	query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	List results = query.list();
	
	String sql = "SELECT * FROM EMPLOYEE";
	SQLQuery query = session.createSQLQuery(sql);
	query.addEntity(Employee.class);
	List results = query.list();
	
	//Named SQL Queries
	//Following is the syntax to get entity objects from a native sql query via addEntity() and using named SQL query.

	String sql = "SELECT * FROM EMPLOYEE WHERE id = :employee_id";
	SQLQuery query = session.createSQLQuery(sql);
	query.addEntity(Employee.class);
	query.setParameter("employee_id", 10);
	List results = query.list();
	
	//CACHE
	Session session = SessionFactory.openSession();
	Query query = session.createQuery("FROM EMPLOYEE");
	query.setCacheable(true);
	List users = query.list();
	SessionFactory.closeSession();
	
}
