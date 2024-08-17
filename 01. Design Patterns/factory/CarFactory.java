package factory;

public class CarFactory extends ToyFactory {
    @Override
    public Toy makeToy() {
        return new CarToy();
    }

}
