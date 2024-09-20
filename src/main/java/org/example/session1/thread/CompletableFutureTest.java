package org.example.session1.thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {


    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread());
            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread());
            int result = 10 / 0; // Causes an ArithmeticException
            return result;
        }).exceptionally(ex -> {
            return 0;
        });

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread());
            return 20;
        });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);

        allFutures.exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return null; // Default value to return if there's an exception
        }).thenRun(() -> {
            // All futures completed
            int result1 = future1.join();
            int result2 = future2.join();
            int result3 = future3.join();
            System.out.println(result1 + ", " + result2 + ", " + result3);
        });


    }
}
