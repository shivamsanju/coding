package _01_ThreadCreation.Excercise;

import java.util.Random;

public class Main {
    static int maxPassword = 10000;

    public static void main(String[] args) {
        Vault vault = new Vault(new Random().nextInt(maxPassword));
        Thread ascHackerThread = new AscendingHackerThread(vault);
        Thread descHackerThread = new DescendingHackerThread(vault);
        Thread policeThread = new PoliceThread();

        ascHackerThread.start();
        descHackerThread.start();
        policeThread.start();

    }

    private static class Vault {
        private final int password;

        public Vault(int password) {
            this.password = password;
        }

        public boolean doesPasswordMatch(int password) {
            return this.password == password;
        }
    }

    private static abstract class HackerThead extends Thread {
        protected Vault vault;

        public HackerThead(Vault vault) {
            super();
            this.setName(this.getClass().getName());
            this.vault = vault;
        }

        @Override
        public void start() {
            System.out.println("Starting thread: " + this.getName());
            super.start();
        }
    }

    private static class AscendingHackerThread extends HackerThead {

        public AscendingHackerThread(Vault vault) {
            super(vault);
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void run() {
            for (int i = 0; i < maxPassword; i++) {
                if (vault.doesPasswordMatch(i)) {
                    System.out.println("Password cracked: " + i);
                    System.exit(0);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class DescendingHackerThread extends HackerThead {

        public DescendingHackerThread(Vault vault) {
            super(vault);
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void run() {
            for (int i = maxPassword; i >= 0; i--) {
                if (vault.doesPasswordMatch(i)) {
                    System.out.println("Password cracked: " + i);
                    System.exit(0);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    private static class PoliceThread extends Thread {
        public PoliceThread () {
            this.setName(this.getClass().getName());
        }

        @Override
        public void start(){
            System.out.println("Starting police thread");
            super.start();
        }

        @Override
        public void run(){
            for (int i = 0; i < 10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Caught hackers");
            System.exit(0);
        }
    }

}
