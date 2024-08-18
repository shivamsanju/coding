package observer;

public class Client {
    public static void main(String[] args) {
        LogEventListener logListener = new LogEventListener();

        Editor editor = new Editor();

        editor.addListener("open", logListener);
        editor.addListener("write", logListener);
        editor.addListener("close", logListener);

        editor.openFile("sample.txt");

        editor.writeToFile("Hi, This is joe.");
        editor.writeToFile("Hello there!");

        editor.closeFile();
    }
}
