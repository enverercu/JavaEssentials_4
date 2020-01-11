package Design.Observer;

import java.util.*;

//You have a Loan on which interest rate is subject to change and when it changes, 
//Loan notifies to Newspaper or Internet media to display new loan interest rate

interface Observer{
	public void update(float interest);
}

interface Subject{
	
	public void registerObservers(Observer observer);
	public void notifyObservers();
	
}

//SUBJECT
class Loan implements Subject{
	List<Observer> observers = new ArrayList<Observer>(); //LIST OF OBSERVERS
	
	private float interest;
	
	public Loan(float interest){
		this.interest = interest;
	}
	
	@Override
	public void registerObservers(Observer observer){
		observers.add(observer);
	}
	
	@Override
	public void notifyObservers(){
		for (Observer ob:observers){
			ob.update(this.interest); //SINGLE EVENT CALL : BROADCAST COMMUNICATION
		}
	}
	
	public void setInterest(float interest){
		this.interest = interest;
		notifyObservers(); //VERY IMPORTANT FOR TRIGGERING OBSERVERS FOR EVERY INTEREST CHANGE
	}
}

//OBSERVER
class NewsPaper implements Observer{
	@Override
	public void update(float interest){
		System.out.println("Newspaper: new interest rate is " + interest );
	}
}

public class AAObserverTest {

	public static void main(String[] args){
		
		NewsPaper printMedia = new NewsPaper(); //OBSERVER	
		
		Loan loan = new Loan(12.5f); //SUBJECT
		
		loan.registerObservers(printMedia);
		
		loan.setInterest(11.5f);
	}
	
}
