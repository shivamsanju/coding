package parkinglot;

import parkinglot.ChargeCalulator.HourlyChargeCalculator;
import parkinglot.ChargeCalulator.ParkingChargeCalculator;

public class PaymentService {
    final private ParkingChargeCalculator parkingChargeCalculator;
    private Double totalCollection;

    public PaymentService() {
        totalCollection = 0.0;
        this.parkingChargeCalculator = new HourlyChargeCalculator();
    }

    public void processPayment(Ticket ticket) {
        Double charge = parkingChargeCalculator.calculateCharge(ticket);
        totalCollection += charge;
        System.out.println("Payment of INR:" + charge + " processed for ticket id: " + ticket.getId());
    }

    public Double getTotalCollection() {
        return totalCollection;
    }
}
