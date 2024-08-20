package parkinglot;

import parkinglot.ParkingSpot.ParkingSpot;
import parkinglot.ParkingSpot.ParkingSpotType;
import parkinglot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotService {
    final private Map<ParkingSpotType, List<ParkingSpot>> parkingSpots;
    PaymentService paymentService;

    public ParkingLotService() {
        paymentService = new PaymentService();
        parkingSpots = new HashMap<>();
        for (ParkingSpotType parkingSpotType : ParkingSpotType.values()) {
            parkingSpots.put(parkingSpotType, new ArrayList<>());
        }
    }

    public Ticket generateParkingTicket(ParkingSpot parkingSpot, Vehicle vehicle) {
        return new Ticket(parkingSpot, vehicle);
    }

    public Ticket assignParkingSpot(ParkingSpotType parkingSpotType, Vehicle vehicle) throws ParkingFullException {
        List<ParkingSpot> spotsOfType = parkingSpots.get(parkingSpotType);
        for (ParkingSpot spot : spotsOfType) {
            if (spot.isAvailable()) {
                spot.assignSpot(vehicle);
                return generateParkingTicket(spot, vehicle);
            }
        }
        throw new ParkingFullException();
    }

    public void unParkVehicle(Ticket ticket) {
        paymentService.processPayment(ticket);
        ticket.getParkingSpot().releaseSpot();
    }
}
