package Design.Factory;

//Here we have made Currency as interface and all currency would be concrete implementation of Currency interface. 
//Factory Class will create Currency based upon country and return concrete implementation which will be stored in interface type

interface Currency{
	public String getSymbol();
}

class USDollar implements Currency{
	
	@Override
	public String getSymbol(){
		return "USD";
	}
}

class EuroMoney implements Currency{
	
	@Override
	public String getSymbol(){
		return "EUR";
	}
}

class CurrencyFactory{
	//MUST BE STATIC
	public static Currency createCurrency(String country){ 
		
		if (country.equalsIgnoreCase("USA")){
			return new USDollar();
		}
		else if (country.equalsIgnoreCase("Europa"))
		{
			return new EuroMoney();
		}
		
		return null;
	}
}

public class AATest {

	public static void main(String[] args) {
		
		Currency c = CurrencyFactory.createCurrency("USA"); //WITHOUT NEW OPERATOR
		
		System.out.println(c.getSymbol());

	}

}
