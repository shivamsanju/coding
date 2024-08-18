package chainofresponsibility;

public interface Handler {

    void addNextHandler(Handler handler);

    String handleRequest(String request);

}
