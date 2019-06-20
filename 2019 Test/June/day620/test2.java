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
class Threadshow implements Runnable{
    /*
         Threadshow m1 = new Threadshow();
        Thread thread = new Thread(m1);
        thread.start();
        Thread.sleep(1000);
        //m1.setFlag(false);
        //thread.stop();
        //Threa 提供 public boolean isInterrupted() 可以检测当前线程状态 判断是否中断
        thread.interrupt();
     */
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int i = 0;
        while(flag){


           /* try {
                Thread.sleep(10);
                boolean bool = Thread.currentThread().isInterrupted();
                if(bool){
                    System.out.println("线程中断");
                    return;
                }
                System.out.println("当前线程状态try"+bool);
                System.out.println(Thread.currentThread().getName()+"当前"+i++);
            } catch (InterruptedException e) {
                System.out.println("抛出中断异常");
                return;
             *//*   e.printStackTrace();
                boolean bool = Thread.currentThread().isInterrupted();
                if(bool){
                    System.out.println("线程中断");
                    return;
                }
                System.out.println("当前线程状态catch"+bool);
                System.out.println(Thread.currentThread().getName()+"当前"+i++);*//*
            }*/
        }
        System.out.println("GG'");
    }
}
public class Threadtest {
    public static void main(String[] args) throws InterruptedException {

    }

    private static void code2() throws InterruptedException {
        System.out.println("主线程开始");
        Runnable m1 = new MyThread();
        Thread tt = new Thread(m1);
        Thread tt1 = new Thread(m1);
        Thread tt2 = new Thread(m1);
        tt.start();
        tt1.start();
        tt2.start();
        tt.join();
        System.out.println("主线程执行完毕");

        // MyTicketThread tt  = new MyTicketThread();
       /* Callable<String> callable = new MyTicketCallable();
        FutureTask<String> future = new FutureTask<>(callable);
        Thread thread = new Thread(future);
        Thread thread1 = new Thread(future);
        thread.start();
        thread1.start();*/
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
