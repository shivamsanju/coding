package state;

public class RedLightState implements TrafficLightState {
    @Override
    public void changeToGreen(TrafficLight trafficLight) {
        trafficLight.changeState(new GreenLightState());
    }

    @Override
    public void changeToRed(TrafficLight trafficLight) {
        // pass
    }

    @Override
    public void changeToYellow(TrafficLight trafficLight) {
        trafficLight.changeState(new YellowLightState());
    }
}
