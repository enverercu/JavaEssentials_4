package Design.Singleton;

public class SingletonEagerLoading {

	//creating Singleton static final instance during class loading
	private static final SingletonEagerLoading instance = new SingletonEagerLoading();//early initialization
	
	private SingletonEagerLoading(){

	}
	
	//creating thread safe singleton in Java using "static factory" method
	//getInstance() serves as static factory method.
	public static SingletonEagerLoading getInstance(){
		return instance;
	}
	
	public static void main(String[] args){
		SingletonEagerLoading s = SingletonEagerLoading.getInstance();
	}
}
