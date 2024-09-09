package _08.semaphores;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerService {
    private static final int BUFFER_SIZE = 10;
    private final Deque<Integer> queue = new ArrayDeque<>();

    private final Semaphore emptySlots = new Semaphore(BUFFER_SIZE); // Available empty slots in the buffer
    private final Semaphore fullSlots = new Semaphore(0); // Available full slots (items to consume)
    private final Lock lock = new ReentrantLock();

    class Producer implements Runnable {
        public void run() {
            try {
                for (int i = 1; i <= 10; i++) {
                    emptySlots.acquire();

                    lock.lock();
                    queue.offer(i);
                    System.out.println("Produced item: " + i);
                    lock.unlock();

                    fullSlots.release();
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    class Consumer implements Runnable {
        public void run() {
            try {
                for (int i = 1; i <= 10; i++) {
                    fullSlots.acquire();

                    lock.lock();
                    int item = queue.poll();
                    lock.unlock();

                    emptySlots.release();
                    Thread.sleep(200);
                    System.out.println("Consumed item: " + item);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerService pc = new ProducerConsumerService();

        Thread producer = new Thread(pc.new Producer());
        Thread consumer1 = new Thread(pc.new Consumer());
        Thread consumer2 = new Thread(pc.new Consumer());
        Thread consumer3 = new Thread(pc.new Consumer());

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

        try {
            producer.join();
            consumer1.join();
            consumer2.join();
            consumer3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("In");
        }

    }
}
