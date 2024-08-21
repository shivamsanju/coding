package parkinglot;

import parkinglot.ParkingSpot.ParkingSpot;
import parkinglot.ParkingSpot.ParkingSpotService;
import parkinglot.Vehicle.Vehicle;

public class BookingService {
    final private ParkingSpotService parkingSpotService;
    final private PaymentService paymentService;

    public BookingService(ParkingSpotService parkingSpotService) {
        paymentService = new PaymentService();
        this.parkingSpotService = parkingSpotService;
    }

    private Ticket generateParkingTicket(ParkingSpot parkingSpot, Vehicle vehicle) {
        return new Ticket(parkingSpot, vehicle);
    }

    public Ticket assignParkingSpot(Vehicle vehicle) {
        ParkingSpot freeSpot = parkingSpotService.getNextFreeSpot(vehicle);
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
