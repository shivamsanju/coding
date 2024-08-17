package abstract_factory;

import abstract_factory.car.Car;
import abstract_factory.car.VintageCar;
import abstract_factory.house.Bunglow;
import abstract_factory.house.House;

public class VintageLifestyleFactory implements LifestyleFactory {

    @Override
    public Car makeCar() {
        return new VintageCar();
    }

    @Override
    public House makeHouse() {
        return new Bunglow();
    }

}
