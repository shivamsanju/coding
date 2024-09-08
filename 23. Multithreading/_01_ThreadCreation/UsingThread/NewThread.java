package _01_ThreadCreation.UsingThread;

public class NewThread extends Thread{

    @Override
    public void run(){
        System.out.println("Running thread using thread class directly. -> " + this.getName());
    }
}
