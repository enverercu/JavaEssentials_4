package Design.Adaptor;

//An Adapter wraps an existing class with a new interface so that it becomes compatible with the client’s interface
//The main motive behind using this pattern is to convert an existing interface into another interface that the client expects

interface Speed{
	// returns speed in MPH 
    double getSpeed();
}
//concrete class
class BugattiVeyron implements Speed {
	  
    @Override
    public double getSpeed() {
        return 268; //MPH
    }
}
interface SpeedAdapter {
    // returns speed in KM/H 
    double getSpeed();
}

class SpeedAdapterImpl implements SpeedAdapter{
	private Speed speed;
	public SpeedAdapterImpl(Speed speed){
		this.speed = speed;
	}
	@Override
    public double getSpeed() {
        return convertMPHtoKMPH(speed.getSpeed());
    }
	private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}
public class AATest{
	public static void main(String args[]){
		Speed bugattiVeyron = new BugattiVeyron();
		SpeedAdapter bugattiVeyronAdapter = new SpeedAdapterImpl(bugattiVeyron);
		System.out.println(bugattiVeyronAdapter.getSpeed());
		
    }
}
