package com.bite.com.bite.ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class MyTicketThread extends Thread{
    private int ticket = 10;

    @Override
    public void run() {
        while(this.ticket>0){
            System.out.println("---剩余票数"+this.ticket--+Thread.currentThread().getName());
        }
    }
}
class MyTicketRunnable implements Runnable{
    private int ticket = 10;
    @Override
    public void run() {
        while(this.ticket>0){
            System.out.println("---剩余票数"+this.ticket--+Thread.currentThread().getName());
        }
    }
}
class MyTicketCallable implements Callable<String>{
    private int ticket = 10;
    @Override
    public String call() {
        while(this.ticket>0){
            System.out.println("---剩余票数"+this.ticket--+Thread.currentThread().getName());
        }
        return "GG";
    }
}
public class Threadtest {
    public static void main(String[] args) throws InterruptedException {
       // MyTicketThread tt  = new MyTicketThread();
        Callable<String> callable = new MyTicketCallable();
        FutureTask<String> future = new FutureTask<>(callable);
        Thread thread = new Thread(future);
        Thread thread1 = new Thread(future);
        thread.start();
        thread1.start();
        /*
        MyTicketCallable tt = new MyTicketCallable();
        Thread t1 = new Thread(tt);
        Thread t2  =new Thread(tt);
        t1.start();
        t2.start();*/

    }

    private static void code() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runable run执行");
                for(int i=0;i<20;i++){
                    System.out.println("A"+i);
                }
            }
        }).start();

        new Thread(()->{
            System.out.println("Runable run执行");
            for(int i=0;i<10;i++){
                System.out.println("B"+i);
            }
        }).start();
    }
}
