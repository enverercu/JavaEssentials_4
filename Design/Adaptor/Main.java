package Design.Adaptor;

public class Main {

    public static void main(String args[])
    {
        Parrot parrot = new Parrot();
        ToyDuck toyDuck = new PlasticToyDuck();

        // Wrap a bird in a birdAdapter so that it
        // behaves like toy duck
        ToyDuck birdAdapter = new BirdAdapter(parrot);

        System.out.println("parrot...");
        parrot.fly();
        parrot.makeSound();

        System.out.println("ToyDuck...");
        toyDuck.squeak();

        // toy duck behaving like a bird
        System.out.println("BirdAdapter...");
        birdAdapter.squeak();
    }
}
