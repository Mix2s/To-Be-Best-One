package src.javatest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class real {
    public static void main(String[] args) {
        Subject proxySubject = ProxyFactory.getProxyInstance(
                "src.javatest.RealSubject1",
                "src.javatest.ProxySubject1"
        );
        if(proxySubject!=null){
            proxySubject.eat();
        }
    }
}
interface Subject{
    void eat();
}
class ProxyFactory{
    private ProxyFactory(){

    }
    public static <T> T getInstance(String className){
        try {
            Class cls = Class.forName(className);
            return (T)cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static <T> T getInstance(String className,Object realObject){
        try {
            Class cls = Class.forName(className);
            Class interfaceCls = cls.getInterfaces()[0];
            Constructor con = cls.getConstructor(interfaceCls);
            return (T)con.newInstance(realObject);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static <T> T getProxyInstance(String realClassName,String proxyClassName){
        Subject realSubject = ProxyFactory.getInstance(realClassName);
        if(realSubject!=null){
            Subject proxySubject = ProxyFactory.getInstance(proxyClassName,realSubject);
            if(proxyClassName!=null){
                return (T)proxySubject;
            }
        }
        return null;
    }
}
class RealSubject1 implements Subject{
    @Override
    public void eat() {
        System.out.println("吃饭饭");
    }
}
class ProxySubject1 implements Subject{
    private Subject target;

   public ProxySubject1(Subject target){
       this.target = target;
   }
   private void before(){
       System.out.println("吃屎");
   }
   public void eat(){
       this.before();
       target.eat();
       this.after();
   }
   private void after(){
       System.out.println("吃完屎1");
   }
}
