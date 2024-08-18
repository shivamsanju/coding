package chainofresponsibility;

public class ContentTypeHandler implements Handler {
    private Handler nextHandler;
    private String contentType;

    public ContentTypeHandler(String contentType) {
        this.contentType = contentType;
    }

    public void addNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    public String handleRequest(String request) {
        request += "ContentType = " + this.contentType + "; ";
        if (nextHandler != null) {
            return nextHandler.handleRequest(request);
        } else {
            return request;
        }
    }
}
