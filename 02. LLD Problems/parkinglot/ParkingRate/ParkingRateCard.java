package parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingRate {
    final private Map<ParkingRateType, Map<ParkingSpotType, Double>> rates;

    public ParkingRate() {
        this.rates = new HashMap<>();
        for (ParkingRateType rateType : ParkingRateType.values()) {
            rates.put(rateType, new HashMap<>());
        }
    }

    public Double getRate(ParkingRateType parkingRateType, ParkingSpotType parkingSpotType) {
        return rates.get(parkingRateType).get(parkingSpotType);
    }

    public void setRate(ParkingRateType parkingRateType, ParkingSpotType parkingSpotType, Double rate) {
        Map<ParkingSpotType, Double> ratesMap = rates.get(parkingRateType);
        ratesMap.put(parkingSpotType, rate);
    }

}
