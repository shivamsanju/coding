package _03.join;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Long[] inputs = new Long[]{1000000L, 20L, 300000000L, 40000000000L, 5876657653786385345L};
        FactorialThread[] threads = new FactorialThread[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            threads[i] = new FactorialThread(inputs[i]);
            threads[i].start();
        }

        // Before calling join
        for (int i = 0; i < inputs.length; i++) {
            if (threads[i].isFinished()) {
                System.out.printf("Finished calculating factorial of %d. Result is %d\n", inputs[i], threads[i].getResult());
            } else {
                System.out.printf("Still calculating of %d\n", inputs[i]);
            }
        }

        // After calling join
        System.out.println("------------------ AFTER CALLING JOIN ------------------");
        for (FactorialThread t: threads) {
            t.join(2000); // wait for max 2s
            System.out.println("Joining thread: " + t.getName());
        }

        for (int i = 0; i < inputs.length; i++) {
            if (threads[i].isFinished()) {
                System.out.printf("Finished calculating factorial of %d. Result is %d\n", inputs[i], threads[i].getResult());
            } else {
                System.out.printf("Still calculating of %d\n", inputs[i]);
            }
        }


        // Interrupt Threads
        for (FactorialThread t: threads) {
            t.interrupt();
        }
    }

    private static class FactorialThread extends Thread {
        private boolean isFinished;
        private BigInteger result;
        private Long input;

        FactorialThread(Long x) {
            input = x;
        }

        @Override
        public void run() {
            result = BigInteger.ONE;
            for (Long i = 1L; i <= input; i++) {
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("Prematurely exiting");
                    result = BigInteger.ZERO;
                    return;
                }
                result = result.multiply(new BigInteger(String.valueOf(i)));
            }
            isFinished = true;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
