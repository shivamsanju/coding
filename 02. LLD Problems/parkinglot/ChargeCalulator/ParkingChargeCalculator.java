package parkinglot.ChargeCalulator;

import parkinglot.Ticket;

public interface ParkingChargeCalculator {
    public Double calculateCharge(Ticket ticket);
}
