package _02.termination;

/* We can use interrupt method on thread in 3 scenarios:
1. If the thread is executing a method that throws InterruptException
2. If the thread code handles interrupt signal explicitly.
3. Set the child thread to daemon thread so it ends as soon as main thread ends
 */

public class UsingInterruptException {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new BlockingThread();
        t.start();
        t.interrupt();

    }

    private static class BlockingThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                System.out.println("Exiting due to interrupt signal");
            }
        }
    }
}
