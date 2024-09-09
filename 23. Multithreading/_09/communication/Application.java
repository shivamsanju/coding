package _09.communication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

// Since backpressure is not handled, it can lead to out of memory exception
public class Application {
    private static int maxQueueSize = 0;

    public static void main(String[] args) throws FileNotFoundException {
        ThreadSafeQueue<String> queue = new ThreadSafeQueue<>(new ArrayDeque<>());
        String filePath = "./_09/communication/resources/war_and_peace.txt";
        FileReader reader = new FileReader(filePath);

        Thread producer = new ProducerThread(reader, queue);
        Thread consumer1 = new ConsumerThread(queue);
        Thread consumer2 = new ConsumerThread(queue);

        producer.start();
        consumer1.start();
        consumer2.start();

        try {
            producer.join();
            consumer1.join();
            consumer2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Max queue size reached: " + maxQueueSize);
    }

    private static class ProducerThread extends Thread {
        private final Scanner scanner;
        private final ThreadSafeQueue<String> queue;

        ProducerThread(FileReader reader, ThreadSafeQueue<String> queue) {
            this.scanner = new Scanner(reader);
            this.queue = queue;
        }

        @Override
        public void run() {
            while (scanner.hasNextLine()) {
                queue.add(scanner.nextLine());
            }
            queue.terminate();
        }

    }

    private static class ConsumerThread extends Thread {
        private final ThreadSafeQueue<String> queue;

        ConsumerThread(ThreadSafeQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while(!queue.isTerminated || !queue.isEmpty()){
                int numberOfWords = getNumWordsInString(queue.remove());
                System.out.println("Number of words: " + numberOfWords);
            }
        }

        private int getNumWordsInString(String str) {
            return str.split(" ").length;
        }

    }


    private static class ThreadSafeQueue<R> {
        private final Queue<R> queue;
        public boolean isTerminated;

        ThreadSafeQueue(Queue<R> queue) {
            this.queue = queue;
            isTerminated = false;
        }

        public synchronized void add(R line) {
            queue.offer(line);
            notify();
        }

        public synchronized R remove() {
            while (!isTerminated && queue.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            maxQueueSize = Math.max(queue.size(), maxQueueSize);
            return queue.poll();
        }

        public synchronized void terminate() {
            isTerminated = true;
        }

        public synchronized boolean isEmpty() {
            return queue.isEmpty();
        }

    }
}
