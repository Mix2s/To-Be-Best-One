package main.ProducerAndConsumer;
class Resource{
    private String name;
    private int count = 1;
    private boolean flag;

    public synchronized void set(String name){
        while(flag){
            try{
                this.wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        this.name = name + count;

        count++;

        System.out.println(
                Thread.currentThread().getName()+"This was producered" +
                        ":"+this.name);
        flag = true;
        this.notifyAll();
    }
    public synchronized void out(){
        while(!flag){
            try{
                this.wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName()
        +"The consumer is:"+this.name);

        flag = false;
        this.notifyAll();
    }
}
class Producer implements Runnable{
    private Resource r;
    public Producer(Resource r){
        this.r = r;
    }
    @Override
    public void run() {
        while(true){
            r.set("商品");
        }
    }
}
class Consumer implements Runnable{
    private Resource r;
    public Consumer(Resource r){
        this.r = r;
    }
    @Override
    public void run() {
        while (true){
            r.out();
        }
    }
}

public class ProAndCons {
    public static void main(String[] args) {
        Resource r = new Resource();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(pro);
        Thread t3 = new Thread(con);
        Thread t4 = new Thread(con);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
