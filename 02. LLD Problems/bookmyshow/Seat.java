package bookmyshow;

public class Seat {
    private String id;
    private SeatType seatType;
    private double price;
    private boolean isBooked;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable(){
        return this.isBooked;
    }

    public synchronized boolean bookTicket(){
        if(!this.isBooked){
            this.isBooked = true;
            return true;
        }
        return false;
    }
}
