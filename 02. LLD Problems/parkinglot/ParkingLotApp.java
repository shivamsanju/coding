package parkinglot;

import parkinglot.ParkingRate.HourlyRateCard;
import parkinglot.ParkingRate.ParkingRateCard;
import parkinglot.ParkingSpot.ParkingSpotController;
import parkinglot.ParkingSpot.ParkingSpotType;
import parkinglot.Vehicle.Vehicle;
import parkinglot.Vehicle.VehicleType;

public class ParkingLotApp {
    final private BookingService bookingService;
    final private ParkingSpotController parkingSpotController;
    final private ParkingRateCard parkingRateCard;

    public ParkingLotApp() {
        this.parkingSpotController = new ParkingSpotController();
        this.bookingService = new BookingService(parkingSpotController);
        this.parkingRateCard = HourlyRateCard.getRateCard();
    }

    private void setRates() {
        parkingRateCard.setRate(ParkingSpotType.COMPACT, 50.0);
        parkingRateCard.setRate(ParkingSpotType.STANDARD, 100.0);
        parkingRateCard.setRate(ParkingSpotType.LARGE, 150.0);
    }

    private void addParkingSpots() {
        for (int i = 1; i < 21; i++) {
            parkingSpotController.addParkingSpot(i, ParkingSpotType.COMPACT);
        }
        for (int i = 21; i < 41; i++) {
            parkingSpotController.addParkingSpot(i, ParkingSpotType.STANDARD);
        }
        for (int i = 41; i < 51; i++) {
            parkingSpotController.addParkingSpot(i, ParkingSpotType.LARGE);
        }
    }

    public void setup() {
        setRates();
        addParkingSpots();
    }

    public void demo() {
        try {
            Ticket t1 = bookingService.assignParkingSpot(new Vehicle("KA01-001", VehicleType.TWO_WHEELER));
            Ticket t2 = bookingService.assignParkingSpot(new Vehicle("KA01-002", VehicleType.FOUR_WHEELER));
            Ticket t3 = bookingService.assignParkingSpot(new Vehicle("KA01-003", VehicleType.TWO_WHEELER));
            Ticket t4 = bookingService.assignParkingSpot(new Vehicle("KA01-004", VehicleType.TWO_WHEELER));
            Ticket t5 = bookingService.assignParkingSpot(new Vehicle("KA01-005", VehicleType.FOUR_WHEELER));
            Ticket t6 = bookingService.assignParkingSpot(new Vehicle("KA01-006", VehicleType.FOUR_WHEELER));
            Ticket t7 = bookingService.assignParkingSpot(new Vehicle("KA01-007", VehicleType.LARGE_FOUR_WHEELER));

            Thread.sleep(5000);

            bookingService.checkout(t1);
            bookingService.checkout(t2);
            bookingService.checkout(t3);
            bookingService.checkout(t4);
            bookingService.checkout(t5);
            bookingService.checkout(t6);
            bookingService.checkout(t7);

            System.out.println("Total Collection: " + bookingService.getTotalCollection());

            for (int i = 1; i < 15; i++) {
                Ticket t = bookingService.assignParkingSpot(new Vehicle("KA01-00" + i, VehicleType.LARGE_FOUR_WHEELER));
                if (t == null) {
                    System.out.println("Parking is full for LARGE FOUR WHEELERS!");
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
