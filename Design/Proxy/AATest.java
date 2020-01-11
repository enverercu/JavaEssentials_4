package Design.Proxy;

//The Proxy pattern allows us to create an intermediary that acts as an interface to another resource.
//Consider a heavy Java object (like a JDBC connection or a SessionFactory) that requires some initial configuration.
//We only want such objects to be initialized on demand, and once they are, we'd want to reuse them for all calls

interface ExpensiveObject{
	public void process();
}
//we may represent it with a skeleton object which loads the original object on demand, also called as lazy initialization
class ExpensiveObjectImpl implements ExpensiveObject{
	public ExpensiveObjectImpl(){
		heavyInitial();
	}
	@Override
	public void process(){
		System.out.println("Processing complete.");
	}
	private void heavyInitial(){
		System.out.println("Loading initial configuration...");
	}
	
}
class ExpensiveObjectProxy implements ExpensiveObject{
	private static ExpensiveObject object;
	
	@Override
	public void process(){
		if (object == null){
			object = new ExpensiveObjectImpl();
		}
		object.process();
	}
}

public class AATest {

	//Note that we're calling the process() method twice. Behind the scenes, the settings part will occur only once – when the object is first initialized.
	public static void main(String[] args) {
		ExpensiveObject object = new ExpensiveObjectProxy();
		object.process();
	}

}
