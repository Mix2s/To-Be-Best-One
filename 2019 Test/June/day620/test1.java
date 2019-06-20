package com.bite.com.bite.ThreadTest;
class MyThread implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                //Thread.sleep(100);
                //Thread.yield();
                System.out.println(Thread.currentThread().getName()+"当前数字"+i);
                System.out.println(Thread.currentThread().getPriority());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class DaemonTest implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName()+"带那个钱线程"+Thread.currentThread().isDaemon());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName()+"带那个钱线程"+Thread.currentThread().isDaemon());
                System.out.println(Thread.currentThread().getName()+"GG");
                return;
            }
        }
    }
}
public class ThreadTest2 {
    public static void main(String[] args) throws InterruptedException {
        DaemonTest dd = new DaemonTest();
        Thread t1 = new Thread(dd);
        Thread t2 = new Thread(dd);
        t1.setDaemon(true);
        t1.start();
        t2.start();
        Thread.sleep(300);
        t2.interrupt();
        Thread.sleep(100);
        System.out.println("结束代码");
    }

    private static void code1() {
        MyThread m1 = new MyThread();
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m1);
        Thread t3 = new Thread(m1);
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
