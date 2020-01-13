package Design.ChainOfResponsibility;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class ATMDispenseChainTest {

	@Test
	public void m1(){
		ATMDispenseChain atmDispenser = new ATMDispenseChain();
		DispenseChain c1 = atmDispenser.getStartPoint();
		Scanner scanner = new Scanner(System.in);
		boolean bad = true;
		do{
			try{
				int amount = 0;
				System.out.println("Enter amount to dispense:");
				amount = scanner.nextInt();
				if (amount % 10 != 0){
					throw new RuntimeException("Amount should be multiple of 10s.");
				}
				bad = false;
				//process the request
				c1.dispense(new Currency(amount));
			}
			catch(Exception ex){
				System.out.println(ex.getMessage());
	            scanner.nextLine();
			}			
		}while(bad);
	}
}
