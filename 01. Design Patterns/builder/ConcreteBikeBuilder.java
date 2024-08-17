package builder;

public class ConcreteBikeBuilder implements BikeBuilder {
    private Bike bike;

    @Override
    public void build(String model) {
        this.bike = Bike.build(model);
    }

    @Override
    public void setTripperTransmission(boolean tripperTransmission) {
        bike.setTripperTransmission(tripperTransmission);
    }

    @Override
    public void setVisor(boolean visor) {
        bike.setVisor(visor);
    }

    public Bike getBike() {
        return bike;
    }
}
