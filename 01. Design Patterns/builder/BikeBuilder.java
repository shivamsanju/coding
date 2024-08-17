package builder;

public interface BikeBuilder {
    void build(String model);

    void setTripperTransmission(boolean tripperTransmission);

    void setVisor(boolean visor);

    Bike getBike();

}
