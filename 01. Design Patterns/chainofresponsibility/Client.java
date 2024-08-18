package chainofresponsibility;

public class Client {
    public static void main(String[] args) {
        Handler authHandler = new AuthHandler();
        Handler contentTypeHandler = new ContentTypeHandler("JSON");
        Handler payloadHandler = new PayloadHandler("{id: 2}");

        authHandler.addNextHandler(contentTypeHandler);
        contentTypeHandler.addNextHandler(payloadHandler);

        String processedRequest1 = authHandler.handleRequest("request1");
        String processedRequest2 = authHandler.handleRequest("request2");

        System.out.println(processedRequest1);
        System.out.println(processedRequest2);
    }
}
