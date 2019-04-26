package src.javaTest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface ISubject{
    void eat(String msg,int num);
}
class RealSubject implements ISubject{
    public void eat(String msg, int num){
        System.out.println("吃"+msg+"几个"+num);
    }
}
class proxySubject implements InvocationHandler {
    // 绑定任意接口的对象，使用Object描述
    private Object target;

    /**
     * 实现真实对象的绑定处理，同时返回代理对象
     *
     * @param target
     * @return 返回一个代理对象(这个对象是根据接口定义动态创建生成的代理对象)
     */
    public Object bind(Object target) {
        this.target = target;
        return (Object) Proxy.newProxyInstance
                (target.getClass().getClassLoader(),target.getClass().getInterfaces(), this);
    }

    public void preHandle() {
        System.out.println("[proxySubject] 处理之前");
    }

    public void afterHandle() {
        System.out.println("[proxySubject]处理之后又");
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.preHandle();
        //反射调用方法
        Object obj = method.invoke(this.target,args);
        this.afterHandle();
        return obj;
    }
}
class Message{
    void send(){
        System.out.println("无敌辉");
    }
}
class ClassProxy implements MethodInterceptor {
    //定义一个拦截器
    private Object target;

    public ClassProxy(Object target) {
        this.target = target;
    }

    public void preHandle() {
        System.out.println("[ProxySubject]方法处理前");
    }

    public void afterHandle() {
        System.out.println("[ProxySubject]方法处理后");
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) {
       this.preHandle();
        Object ret = null;
        try {
            ret = method.invoke(this.target,objects);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        this.afterHandle();
       return ret;
    }
}
@Deprecated
@MyAnnotation(name="wudi",age=25)
class Member implements Serializable{
}
/*
    自定义Annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@interface  MyAnnotation{
    public String name();
    public int age();
}
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnn{
    public String name() default "wudi";
    public int age() default 26;
}
@Deprecated
@MyAnn
class Member1 implements Serializable{

}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnot{
    public Class<?> target();
}
interface  IFruit{
    public void eat();
}
class Apple implements  IFruit{
    @Override
    public void eat(){
        System.out.println("吃屎屎");
    }
}
@MyAnnot(target=Apple.class)
class Factory{
    public static <T> T getInstance() throws IllegalAccessException, InstantiationException {
        MyAnnot mt = Factory.class.getAnnotation(MyAnnot.class);
        return (T)mt.target().newInstance();
    }
}
public class day26 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        IFruit fruit = Factory.getInstance();
        fruit.eat();
    }
    public static void code1(){
        //ISubject subject = (ISubject) new  proxySubject().bind(new RealSubject());
        //subject.eat("我一度",10);
        Message msg = new Message();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(msg.getClass());
        enhancer.setCallback(new ClassProxy(msg));
        Message tmp = (Message) enhancer.create();
        tmp.send();;
        Annotation[] ant = Member.class.getAnnotations();
        for(Annotation a:ant){
            System.out.println(a);
        }
        Annotation[] ant1 = new Annotation[0];
        try {
            ant = Member.class.getMethod("toString").getAnnotations();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for(Annotation a: ant){
            System.out.println(a);
        }
    }
}
