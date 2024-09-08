package _03_ThreadJoin;

import java.math.BigInteger;

public class ComplexCalculation {
    public static void main(String[] args) throws InterruptedException {
        BigInteger res = calculateResult(
                new BigInteger("2"),
                new BigInteger("7"),
                new BigInteger("5"),
                new BigInteger("8")
        );
        System.out.println("Result is: " + res);
    }

    public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result;

        PowerCalculatingThread t1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread t2 = new PowerCalculatingThread(base2, power2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        result = t1.getResult().add(t2.getResult());

        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            for (BigInteger i = BigInteger.ONE; i.compareTo(power) <= 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
        }

        public BigInteger getResult() {
            return result;
        }
    }
}