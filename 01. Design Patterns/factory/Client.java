package factory;

public class Client {

    public static void main(String[] args) {
        ToyFactory carFactory = new CarFactory();
        ToyFactory duckFactory = new DuckFactory();

        Toy car = carFactory.makeToy();
        Toy duck = duckFactory.makeToy();

        car.makeNoise();
        duck.makeNoise();
    }
}
