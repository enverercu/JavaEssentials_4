package Design.Builder;

public class Builder {
    public static void main(String[] args)
    {
        HouseBuilder iglooBuilder = new IglooHouseBuilder();
        HouseBuilder tipiBuilder = new TipiHouseBuilder();

        CivilEngineer engineer = new CivilEngineer(iglooBuilder);

        engineer.constructHouse();
        House house = engineer.getHouse();
        System.out.println("Basement: "+ house.getBasement());

        engineer = new CivilEngineer(tipiBuilder);

        engineer.constructHouse();
        house = engineer.getHouse();
        System.out.println("Basement: "+ house.getBasement());
    }
}
