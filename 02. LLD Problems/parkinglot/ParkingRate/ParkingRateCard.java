package parkinglot.ParkingRate;

import parkinglot.ParkingSpot.ParkingSpotType;

public interface ParkingRateCard {
    public Double getRate(ParkingSpotType parkingSpotType);

    public void setRate(ParkingSpotType parkingSpotType, Double rate);

    ;
}
