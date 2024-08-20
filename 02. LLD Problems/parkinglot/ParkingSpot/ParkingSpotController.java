package parkinglot.ParkingSpot;

import parkinglot.Vehicle.Vehicle;
import parkinglot.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSpotController {
    final private Map<ParkingSpotType, List<ParkingSpot>> parkingSpots;

    public ParkingSpotController() {
        this.parkingSpots = new HashMap<>();
        for (ParkingSpotType parkingSpotType : ParkingSpotType.values()) {
            parkingSpots.put(parkingSpotType, new ArrayList<>());
        }
    }

    public void addParkingSpot(int spotId, ParkingSpotType parkingSpotType) {
        List<ParkingSpot> spotsOfType = parkingSpots.get(parkingSpotType);
        spotsOfType.add(new ParkingSpot(spotId, parkingSpotType));
    }

    public ParkingSpot getNextFreeSpot(Vehicle vehicle) {
        ParkingSpotType parkingSpotType = getParkingSpotType(vehicle.getVehicleType());
        List<ParkingSpot> spotsOfType = parkingSpots.get(parkingSpotType);
        for (ParkingSpot spot : spotsOfType) {
            if (spot.isAvailable()) {
                return spot;
            }
        }
        return null;
    }

    private ParkingSpotType getParkingSpotType(VehicleType vehicleType) {
        if (vehicleType == VehicleType.TWO_WHEELER) {
            return ParkingSpotType.COMPACT;
        } else if (vehicleType == VehicleType.LARGE_FOUR_WHEELER) {
            return ParkingSpotType.LARGE;
        } else {
            return ParkingSpotType.STANDARD;
        }
    }
}
