package Design.Singleton;

public class SingletonLazyLoading {

	private static volatile SingletonLazyLoading instance; //use volatile to make singleton thread-safe
	
	private SingletonLazyLoading(){
		throw new RuntimeException();//You can still access private constructor by reflection and calling setAccessible(true)
	}
	
	//DOUBLE CHECK LOCKING THREAD SAFE SINGLETON
	public SingletonLazyLoading getInstance(){ //not synchronize whole method. Instance oluþmuþ olsa bile sürekli burada bekleme olur.
		if (instance == null){//check
			synchronized(SingletonLazyLoading.class){ //critical section code NOT SYNCRONIZED(this) !!
				if (instance == null){ //double check
					instance = new SingletonLazyLoading();//We are creating instance lazily at the time of the first request comes.
				}
			}
		}
		
		return instance;
	}
}
