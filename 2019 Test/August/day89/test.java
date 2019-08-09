package main;

import java.util.concurrent.*;

class DubbleSingleton{
    private static DubbleSingleton instance;

    public static DubbleSingleton getinstance(){
        if(instance==null){
            synchronized (DubbleSingleton.class){
                if(instance==null){
                    instance = new DubbleSingleton();
                }
            }
        }
        return instance;
    }
}

class Singleton{
    private static Singleton instance = null;
    private Singleton(){

    }
    public static synchronized Singleton newinstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}


public class test {
    public void coarse(){
       synchronized (test.class){
           //TDDD
           //TDDD2
       }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

    }
}
