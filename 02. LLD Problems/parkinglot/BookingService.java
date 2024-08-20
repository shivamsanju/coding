package parkinglot;

import parkinglot.ParkingSpot.ParkingSpot;
import parkinglot.ParkingSpot.ParkingSpotController;
import parkinglot.Vehicle.Vehicle;

public class BookingService {
    final private ParkingSpotController parkingSpotController;
    final private PaymentService paymentService;

    public BookingService(ParkingSpotController parkingSpotController) {
        paymentService = new PaymentService();
        this.parkingSpotController = parkingSpotController;
    }

    private Ticket generateParkingTicket(ParkingSpot parkingSpot, Vehicle vehicle) {
        return new Ticket(parkingSpot, vehicle);
    }

    public Ticket assignParkingSpot(Vehicle vehicle) {
        ParkingSpot freeSpot = parkingSpotController.getNextFreeSpot(vehicle);
        if (freeSpot == null) {
            return null;
        }
        freeSpot.assignSpot(vehicle);
        return generateParkingTicket(freeSpot, vehicle);
    }

    public void checkout(Ticket ticket) {
        paymentService.processPayment(ticket);
        ticket.getParkingSpot().releaseSpot();
    }

    public Double getTotalCollection() {
        return paymentService.getTotalCollection();
    }
}
