package chainofresponsibility;

public class AuthHandler implements Handler {
    private String token = "ef63838dvhksdjhdskjhkdsjvhkdsjvhk";
    private Handler nextHandler;

    public void addNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    public String handleRequest(String request) {
        request += "-> Authorization = Bearer " + this.token + "; ";
        if (nextHandler != null) {
            return nextHandler.handleRequest(request);
        } else {
            return request;
        }
    }
}
