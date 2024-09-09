package _01.creation.UsingThread;

public class NewThread extends Thread{

    @Override
    public void run(){
        System.out.println("Running thread using thread class directly. -> " + this.getName());
    }
}
