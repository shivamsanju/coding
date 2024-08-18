package observer;

public class LogEventListener implements EventListener {

    public void update(String event, String state) {
        System.out.printf("%s event recieved a state : %s \n", event, state);
    }
}
