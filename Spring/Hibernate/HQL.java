package Spring.Hibernate;

public class HQL {

	String hql = "SELECT SUM(E.salary), E.firtName FROM Employee E " +
            "GROUP BY E.firstName";
	Query query = session.createQuery(hql);
	List results = query.list();
	
	
	String hql = "FROM Employee E WHERE E.id = :employee_id";
	Query query = session.createQuery(hql);
	query.setParameter("employee_id",10);
	List results = query.list();
	
	String hql = "UPDATE Employee set salary = :salary "  + 
            "WHERE id = :employee_id";
	Query query = session.createQuery(hql);
	query.setParameter("salary", 1000);
	query.setParameter("employee_id", 10);
	int result = query.executeUpdate();
	System.out.println("Rows affected: " + result);
	
	String hql = "INSERT INTO Employee(firstName, lastName, salary)"  + 
            "SELECT firstName, lastName, salary FROM old_employee";
	Query query = session.createQuery(hql);
	int result = query.executeUpdate();
	System.out.println("Rows affected: " + result);
	
	//we can construct a paging component in our web or Swing application. 
	//Following is the example, which you can extend to fetch 10 rows at a time
	
	String hql = "FROM Employee";
	Query query = session.createQuery(hql);
	query.setFirstResult(1);
	query.setMaxResults(10);
	List results = query.list();
	
	
}
