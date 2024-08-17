package abstract_factory;

import abstract_factory.car.Car;
import abstract_factory.house.House;

public interface LifestyleFactory {

    public Car makeCar();

    public House makeHouse();
}
