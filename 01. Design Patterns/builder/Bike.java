package builder;

public class Bike {
    private String model;
    private boolean tripperTransmission;
    private boolean visor;

    private Bike(String model) {
        this.tripperTransmission = false;
        this.visor = false;
        this.model = model;
    }

    public static Bike build(String model) {
        return new Bike(model);
    }

    // Getters
    public String getModel() {
        return model;
    }

    public boolean hasTripperTransmission() {
        return tripperTransmission;
    }

    public boolean hasVisor() {
        return visor;
    }

    // Setters
    public void setModel(String model) {
        this.model = model;
    }

    public void setTripperTransmission(boolean tripperTransmission) {
        this.tripperTransmission = tripperTransmission;
    }

    public void setVisor(boolean visor) {
        this.visor = visor;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "model='" + model + '\'' +
                ", tripperTransmission=" + tripperTransmission +
                ", visor=" + visor +
                '}';
    }
}
