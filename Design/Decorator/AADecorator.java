package Design.Decorator;

//INTERFACE --> ABSTRACT DECORATOR(INJECTION) IMPLEMENTS INTERFACE--> CONCRETE SIMPLE BASE CLASS + CONCRETE SPECIAL DECORATOR CLASS 1 + CONCRETE SPECIAL DECORATOR CLASS 2

interface Car{
	public String makeCar();
}

class SimpleCar implements Car{
	@Override
	public String makeCar(){
		return "Base Car";
	}
}

abstract class CarDecorator implements Car{
	protected Car specialCar; //INTERFACE INJECTION
	
	public CarDecorator(Car specialCar){
		this.specialCar = specialCar;//INTERFACE CONSTRUCTOR INJECTION
	}
	@Override
	public String makeCar(){
		return specialCar.makeCar();
	}
	
}

class WheelDecorator extends CarDecorator{
	
	public WheelDecorator(Car specialCar){ //CONSTRUCTOR INJECTION
		super(specialCar);
	}
	
	@Override
	public String makeCar(){
		return specialCar.makeCar() + " + 19 inch wheels";
	}
}


public class AADecorator {

	public static void main(String[] args){
		
		Car simpleCar = new SimpleCar();
		System.out.println(simpleCar.makeCar());
		
		Car the19InchCar = new WheelDecorator(new SimpleCar());
		System.out.println(the19InchCar.makeCar());
		
	}
}
