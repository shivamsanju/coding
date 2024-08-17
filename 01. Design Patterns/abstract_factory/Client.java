package abstract_factory;

import abstract_factory.car.Car;
import abstract_factory.house.House;

public class Client {

    public static void main(String[] args) {

        ModernLifestyleFactory modernLifestyleFactory = new ModernLifestyleFactory();
        House house = modernLifestyleFactory.makeHouse();
        Car car = modernLifestyleFactory.makeCar();
        System.out.printf("ModernLifestyleFactory - House Floors: %d, Car Top Speed: %d\n", house.numFloors(),
                car.getTopSpeed());

        VintageLifestyleFactory vintageLifestyleFactory = new VintageLifestyleFactory();
        House house2 = vintageLifestyleFactory.makeHouse();
        Car car2 = vintageLifestyleFactory.makeCar();
        System.out.printf("VintageLifestyleFactory - House Floors: %d, Car Top Speed: %d\n", house2.numFloors(),
                car2.getTopSpeed());
    }
}
