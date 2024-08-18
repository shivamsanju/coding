package chainofresponsibility;

public class PayloadHandler implements Handler {
    private Handler nextHandler;
    private String payloadString;

    public PayloadHandler(String payloadString) {
        this.payloadString = payloadString;
    }

    public void addNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    public String handleRequest(String request) {
        request += "Payload = " + this.payloadString + ";";
        if (nextHandler != null) {
            return nextHandler.handleRequest(request);
        } else {
            return request;
        }
    }

}
