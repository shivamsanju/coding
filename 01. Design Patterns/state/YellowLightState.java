package state;

public class YellowLightState implements TrafficLightState {
    @Override
    public void changeToGreen(TrafficLight trafficLight) {
        trafficLight.changeState(new GreenLightState());
    }

    @Override
    public void changeToRed(TrafficLight trafficLight) {
        trafficLight.changeState(new RedLightState());
    }

    @Override
    public void changeToYellow(TrafficLight trafficLight) {
        // pass
    }
}
