package parkinglot.ParkingSpot;

import parkinglot.Vehicle.VehicleType;

public class ParkingSpotMatcher {
    public static ParkingSpotType getParkingSpotType(VehicleType vehicleType) {
        if (vehicleType == VehicleType.TWO_WHEELER) {
            return ParkingSpotType.COMPACT;
        } else if (vehicleType == VehicleType.LARGE_FOUR_WHEELER) {
            return ParkingSpotType.LARGE;
        } else {
            return ParkingSpotType.STANDARD;
        }
    }
}
