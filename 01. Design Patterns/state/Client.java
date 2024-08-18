package state;

public class Client {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight(new GreenLightState());

        light.changeLightToYellow();
        light.changeLightToRed();
        light.changeLightToGreen();
    }
}
