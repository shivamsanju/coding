package factory;

public class DuckToy implements Toy {

    @Override
    public void makeNoise() {
        System.out.println("Quack Quack!");
    }
}
