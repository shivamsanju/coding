package state;

public class TrafficLight {
    private TrafficLightState state;

    public TrafficLight(TrafficLightState state) {
        this.state = state;
    }

    public void changeState(TrafficLightState state) {
        TrafficLightState previousState = this.state;
        this.state = state;
        System.out.print("Light changed from: " + previousState.getClass().getSimpleName() + " to "
                + state.getClass().getSimpleName() + "\n");
    }

    public void changeLightToGreen() {
        state.changeToGreen(this);
    }

    public void changeLightToRed() {
        state.changeToRed(this);
    }

    public void changeLightToYellow() {
        state.changeToYellow(this);
    }

}
