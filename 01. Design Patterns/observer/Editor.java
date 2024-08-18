package observer;

public class Editor {
    private EventManager eventManager = new EventManager("open", "write", "close");
    private String openFileName;

    public void addListener(String event, EventListener listener) {
        eventManager.subscribe(event, listener);
    }

    public void openFile(String filename) {
        // open file
        this.openFileName = filename;
        eventManager.notifyListener("open", "File " + filename + " opened");
    }

    public void writeToFile(String text) {
        // write
        eventManager.notifyListener("write", "Wrote to " + openFileName + " -> " + text);
    }

    public void closeFile() {
        // close editor
        eventManager.notifyListener("close", "File " + openFileName + " closed.");
    }
}
