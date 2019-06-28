package note2;
class Singleton{
    private static volatile Singleton SIN;
    public Singleton(){}
    public static Singleton getInstance(){
        if (SIN==null){
            synchronized (Singleton.class){
                if(SIN==null){
                    if(SIN==null){
                        SIN = new Singleton();
                    }
                }
            }
        }
        return SIN;
    }
}
public class day628 {
    public static volatile int num = 0;
    public static void increase(){
        num++;
    }
    public static void main(String[] args) {
       Thread[] threads = new Thread[10];
       for(int i=0;i<10;i++){
           threads[i] = new Thread(()->{
                   for(int j=0;j<100;j++){
                       increase();
                   }
           });
           threads[i].start();
        }
       while(Thread.activeCount()>2){
           Thread.yield();
       }
        System.out.println(num);
    }
}
