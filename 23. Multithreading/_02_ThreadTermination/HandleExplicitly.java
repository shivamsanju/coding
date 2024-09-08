package _02_ThreadTermination;

/* We can use interrupt method on thread in 3 scenarios:
1. If the thread is executing a method that throws InterruptException
2. If the thread code handles interrupt signal explicitly.
3. Set the child thread to daemon thread so it ends as soon as main thread ends
 */

public class HandleExplicitly {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new LongRunningTask(1000L, 20000000000L));
        t.start();
        t.interrupt();
    }

    private static class LongRunningTask implements Runnable {
        private long b;
        private long p;

        LongRunningTask(long b, long p) {
            this.b = b;
            this.p = p;
        }

        @Override
        public void run() {
            System.out.printf("%d to the power of %d is %d\n", b, p, pow());
        }

        public long pow() {
            long result = 1;
            for (long i = 1; i <= p; i++) {
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Prematurely exiting thread");
                    return 0L;
                }
                result *= b;
            }

            return result;
        }
    }
}
