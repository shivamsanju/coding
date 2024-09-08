package _01_ThreadCreation.UsingThread;

public class Main {
    public static void main(String[] args) {
        Thread newThread = new NewThread();

        newThread.start();
    }
}
