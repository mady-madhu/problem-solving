package org.example.session1.thread;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Printer p = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(p,10,true),"Even");
        Thread t2 = new Thread(new TaskEvenOdd(p,10,false),"Odd");
        t1.start();
        t2.start();


    }

    public static void firstThreadDemo(){
        for(int i=0;i<10;i++){
            System.out.println("Parent "+i);
        }
    }
}
