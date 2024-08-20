package parkinglot;

public class ParkingSpot {
    final private int id;
    final private ParkingSpotType parkingSpotType;
    private boolean isAvailable;
    private Vehicle parkedVehicle;


    public ParkingSpot(int id, ParkingSpotType parkingSpotType) {
        this.id = id;
        this.parkingSpotType = parkingSpotType;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public synchronized boolean assignSpot(Vehicle vehicle) {
        if (this.isAvailable) {
            this.isAvailable = false;
            this.parkedVehicle = vehicle;
            return true;
        }
        return false;
    }

    public synchronized void releaseSpot() {
        this.isAvailable = true;
        this.parkedVehicle = null;
    }

}
