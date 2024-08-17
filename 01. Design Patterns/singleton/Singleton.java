package singleton;

public class Singleton {

    private static Singleton instance;

    private Singleton() {
        // initialization logic if required
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
