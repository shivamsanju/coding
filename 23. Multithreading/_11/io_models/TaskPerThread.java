package _11.io_models;

/*
 * Copyright (c) 2023. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TaskPerThread {
    private static final int NUMBER_OF_TASKS = 1000;

    public static void main(String[] args) {
        System.out.printf("Running %d tasks\n", NUMBER_OF_TASKS);

        long start = System.currentTimeMillis();
        performTasks(NUMBER_OF_TASKS);
        System.out.printf("Tasks took %dms to complete\n", System.currentTimeMillis() - start);

        System.out.printf("Running %d tasks\n", NUMBER_OF_TASKS * 1000);
        start = System.currentTimeMillis();
        performTasks(NUMBER_OF_TASKS * 1000);
        System.out.printf("Tasks took %dms to complete\n", System.currentTimeMillis() - start);
    }

    private static void performTasks(int numberOfTasks) {
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {

            for (int i = 0; i < numberOfTasks; i++) {
                executorService.submit(() ->  blockingIoOperation());
            }
        }
    }

    // Simulates a long blocking IO
    private static void blockingIoOperation() {
        System.out.println("Executing a blocking task from thread: " + Thread.currentThread());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}