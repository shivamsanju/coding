package singleton;

public class ThreadsafeSingleton {
    private static ThreadsafeSingleton instance;

    private ThreadsafeSingleton() {
    }

    /*
     * The synchronized keyword is used to avoid these issues by ensuring that only
     * one thread can execute a synchronized block of code or method at a time.
     * 
     * When a thread enters a synchronized block or method, it acquires a lock (also
     * known as a monitor) for the object or class whose code is being synchronized.
     * While the thread holds this lock, no other thread can execute any
     * synchronized code that locks on the same object or class.
     */
    public static synchronized ThreadsafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadsafeSingleton();
        }
        return instance;
    }
}
