package facade;

public class SoundSystem {
    public void turnOn() {
        System.out.println("Turned on Sound System");
    }

    public void setVolume(int volume) {
        System.out.println("Setting volume to: " + volume);
    }

    public void turnOff() {
        System.out.println("Turned off Sound System");
    }
}
