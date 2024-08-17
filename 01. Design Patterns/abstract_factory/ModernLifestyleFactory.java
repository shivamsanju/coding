package abstract_factory;

import abstract_factory.car.Car;
import abstract_factory.car.SportsCar;
import abstract_factory.house.Apartment;
import abstract_factory.house.House;

public class ModernLifestyleFactory implements LifestyleFactory {

    @Override
    public Car makeCar() {
        return new SportsCar();
    }

    @Override
    public House makeHouse() {
        return new Apartment();
    }
}
