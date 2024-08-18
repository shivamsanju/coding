package facade;

public class DvdPlayer {
    public void turnOn() {
        System.out.println("Turned on DVD");
    }

    public void playMovie(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void turnOff() {
        System.out.println("Turned off DVD");
    }
}
