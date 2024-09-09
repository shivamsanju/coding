package _01.creation.UsingRunnable;

public class NewThread implements Runnable {

    @Override
    public void run() throws RuntimeException{
        System.out.println("Running the thread..." + Thread.currentThread().getName());
        throw new RuntimeException("ERROR !!!!!!");
    }
}
