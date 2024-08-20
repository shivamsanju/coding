package parkinglot.ParkingRate;

import parkinglot.ParkingSpot.ParkingSpotType;

import java.util.HashMap;
import java.util.Map;

public class HourlyRateCard implements ParkingRateCard {
    private static ParkingRateCard instance;
    final private Map<ParkingSpotType, Double> rates;

    private HourlyRateCard() {
        this.rates = new HashMap<>();
    }

    public static synchronized ParkingRateCard getRateCard() {
        if (instance == null) {
            instance = new HourlyRateCard();
        }
        return instance;
    }

    @Override
    public Double getRate(ParkingSpotType parkingSpotType) {
        return rates.get(parkingSpotType);
    }

    @Override
    public void setRate(ParkingSpotType parkingSpotType, Double rate) {
        rates.put(parkingSpotType, rate);
    }
}
