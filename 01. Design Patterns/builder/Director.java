package builder;

public class Director {

    public static void main(String[] args) {
        BikeBuilder bikeBuilder = new ConcreteBikeBuilder();

        bikeBuilder.build("Meteor 350 Fireball");
        Bike meteorFireball = bikeBuilder.getBike();

        bikeBuilder.build("Meteor 350 Supernova");
        bikeBuilder.setTripperTransmission(true);
        bikeBuilder.setVisor(true);
        Bike meteorSupernova = bikeBuilder.getBike();

        System.out.println(meteorFireball);
        System.out.println(meteorSupernova);
    }
}
