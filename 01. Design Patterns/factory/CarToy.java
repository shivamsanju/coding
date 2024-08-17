package factory;

public class CarToy implements Toy {

    @Override
    public void makeNoise() {
        System.out.println("Honk Honk");
    }
}
