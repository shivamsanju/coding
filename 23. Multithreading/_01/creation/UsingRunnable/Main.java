package _01.creation.UsingRunnable;


public class Main {
    public static void main(String[] args) {
        Thread newThread = new Thread(new NewThread());
        System.out.println("Before creating thread..." + Thread.currentThread().getName());

        // Setting a name of thread
        newThread.setName("Worker Thread");

        // Handling exception in thread
        newThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Error occurred in thread: " + t.getName() + " -> " + e.getMessage());
            }
        });

        // Set Priority
        newThread.setPriority(Thread.MAX_PRIORITY);

        newThread.start();
        System.out.println("After creating thread..." + Thread.currentThread().getName());

    }
}
