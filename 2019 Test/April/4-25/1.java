package src.javatest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

interface ISubject{
    void eat();
}
//真实的业务类
class RealSubject implements ISubject{
    @Override
    public void eat() {
        System.out.println("吃饭饭");
    }
}
//代理类
class ProxySubject implements ISubject{   //代理类 去实现 ISubject接口
    private ISubject subject;

    public ProxySubject(ISubject subject){
        this.subject = subject;
    }
    public void prepare(){
        System.out.println("吃饭饭洗手手");
    }
    public void afterEat(){
        System.out.println("吃完饭饭睡觉觉");
    }
    @Override
    public void eat() {
        this.prepare();
        this.subject.eat();
        this.afterEat();
    }
}
//采用工厂模式的方法 获取对象
class Factory{
    private Factory(){

    }
    //获取业务对象
    public static <T> T getInstance(String className){
        Class cls = className.getClass();
         try {
             return (T)cls.newInstance();       //墙砖为T类型
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
         return null;
    }
    //获取代理对象
    public static <T> T getInstance(String className,Object realObject){
        Class cls  = className.getClass();      //获取类的对象
        Class interfaceCls = cls.getInterfaces()[0];        //拿到接口
        try {
            Constructor con = cls.getConstructor(interfaceCls);  //拿到构造方法
            return (T)con.newInstance(realObject);    //用构造方法创建新的对象 传入realObject
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
    //获取 工厂对象
    public static <T> T getProxyInstance(String realClassName,String  proxyClassName){
        ISubject realSubject =
                Factory.getInstance(realClassName);   //拿到工厂类 对象传入 真实的类名
        if(realSubject!=null){
            ISubject proxySubject =
                    Factory.getInstance(proxyClassName,realClassName);
            if(proxyClassName!=null){
                return (T)proxySubject;
            }
        }
        return null;
    }
}
public class day424 {
    public static void main(String[] args) {
        ISubject proxySubject = Factory.getProxyInstance
                ("src.javatest.RealSubject",
                        "src.javatest.ProxySubject");
        if(proxySubject!=null){
            proxySubject.eat();
        }
    }
}
