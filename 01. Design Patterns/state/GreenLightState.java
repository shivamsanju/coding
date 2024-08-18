package state;

public class GreenLightState implements TrafficLightState {

    @Override
    public void changeToGreen(TrafficLight trafficLight) {
        // pass
    }

    @Override
    public void changeToRed(TrafficLight trafficLight) {
        trafficLight.changeState(new RedLightState());
    }

    @Override
    public void changeToYellow(TrafficLight trafficLight) {
        trafficLight.changeState(new YellowLightState());
    }

}
