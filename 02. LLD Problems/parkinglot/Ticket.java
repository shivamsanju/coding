package parkinglot;

import parkinglot.ParkingSpot.ParkingSpot;
import parkinglot.Vehicle.Vehicle;

import java.util.Date;
import java.util.UUID;

public class Ticket {
    final private String id;
    final private ParkingSpot parkingSpot;
    final private Vehicle vehicle;
    final private Date bookingTime;

    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle) {
        this.id = UUID.randomUUID().toString();
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.bookingTime = new Date();
    }


    public String getId() {
        return id;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void displayTicket() {
        System.out.println("Ticket ID: " + id + "\nParking Spot: " + parkingSpot.getId() + "\nParked Vehicle: " + vehicle.getRegistrationNumber() + "\nBooking Time: " + bookingTime.toString());
    }
}
