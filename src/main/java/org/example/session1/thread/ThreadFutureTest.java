package org.example.session1.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadFutureTest {
    public static void main(String[] args) {
        //test question
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(() -> 1/0);
        try{
            System.out.println(future.get());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        executorService.shutdown();



        //test question
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        Future<Integer> future1 = executorService1.submit(() -> {
            Thread.sleep(1000);
            return 1+1;
        });
        try{
            System.out.println(future1.get());
        }catch (Exception e){
            System.out.println("sleep"+e.getMessage());
        }
        executorService1.shutdown();


        //test question
        int x=5;
        int y = ++x * 10;
        System.out.println(y);



    }
}
