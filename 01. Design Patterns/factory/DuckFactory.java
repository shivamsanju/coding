package factory;

public class DuckFactory extends ToyFactory {
    @Override
    public Toy makeToy() {
        return new DuckToy();
    }
}
