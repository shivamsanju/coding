package parkinglot.ChargeCalulator;

import parkinglot.ParkingRate.HourlyRateCard;
import parkinglot.ParkingRate.ParkingRateCard;
import parkinglot.ParkingSpot.ParkingSpotType;
import parkinglot.Ticket;

import java.util.Date;

public class HourlyChargeCalculator implements ParkingChargeCalculator {
    final private ParkingRateCard parkingRateCard;

    public HourlyChargeCalculator() {
        this.parkingRateCard = HourlyRateCard.getRateCard();
    }

    public int getParkingTimeInHrs(Ticket ticket) {
        double parkingTimeInMs = new Date().getTime() - ticket.getBookingTime().getTime();
        return (int) Math.ceil(parkingTimeInMs / (60 * 60 * 1000));
    }

    @Override
    public Double calculateCharge(Ticket ticket) {
        ParkingSpotType parkingSpotType = ticket.getParkingSpot().getParkingSpotType();
        int parkingTime = getParkingTimeInHrs(ticket);
        Double rateOfSpot = parkingRateCard.getRate(parkingSpotType);
        return rateOfSpot * parkingTime;
    }
}
