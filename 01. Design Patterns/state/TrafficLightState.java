package state;

public interface TrafficLightState {

    public void changeToGreen(TrafficLight trafficLight);

    public void changeToRed(TrafficLight trafficLight);

    public void changeToYellow(TrafficLight trafficLight);
}
