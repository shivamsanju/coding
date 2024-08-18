package facade;

public class Projector {
    private DvdPlayer input;

    public void turnOn() {
        System.out.println("Turned on Projector");
    }

    public void setInput(DvdPlayer dvdPlayer) {
        input = dvdPlayer;
    }

    public void project() {
        if (input != null) {
            System.out.println("Projecting the movie to screen");
        } else {
            System.out.println("No input detected");
        }
    }

    public void turnOff() {
        System.out.println("Turned off Projector");
    }
}
