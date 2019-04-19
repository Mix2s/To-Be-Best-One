package src.com.shuihui.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
interface IFruit{
    void eat();
}
class Apple implements IFruit{

    @Override
    public void eat() {
        System.out.println("苹果");
    }
}
class Orange implements IFruit{

    @Override
    public void eat() {
        System.out.println("橘子");
    }
}
class FruitFactory{
    private FruitFactory(){

    }
    public static IFruit getInstance(String className){
        IFruit fruit = null;
        try {
            fruit = (IFruit) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit;
    }
    /*
    public static IFruit getInstance(String className){
        if("apple".equals(className)){
            return new Apple();
        }
        return null;
    }
    */
}
class Person{
    private String name;
    private int age;
    public Person(){

    }
    public Person(String name){

    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
     Class<?> cls = Class.forName("src.com.shuihui.test.Person");
     Object obj = cls.newInstance(); //拿到一个类的反射对象
     Method setMethod = cls.getMethod("setName", String.class);
     setMethod.invoke(obj,"wudi");
     Method getMethod = cls.getMethod("getName");
     Object result = getMethod.invoke(obj);
        System.out.println(result);
    }
    public static void code1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cls = Person.class;
        Method[] methods = cls.getMethods();  //拿到一个类的所有方法
        for (Method method:methods
        ) {
            System.out.println(method);
        }
        Class<?> cls4 = Person.class;
        Constructor<?> cons = cls.getConstructor(String.class,int.class);
        System.out.println(cons.newInstance("wudi",12));
        Class<?> cls3 = Person.class;
        Constructor<?>[] con = cls.getConstructors(); //拿到类所有的构造对象
        for (Constructor<?> i:con
        ) {
            System.out.println(i);
        }
        Class<?> cls2 = Apple.class;  //所有类的通用方法 调用class的类对象
        String str = cls.getPackage().getName();
        System.out.println(str);
        System.out.println(cls.getSuperclass().getName());
        Class<?>[] iclass = cls.getInterfaces();
        System.out.println(iclass[0]);
        IFruit fruit1 = FruitFactory.getInstance("src.com.shuihui.test.Orange");
        fruit1.eat();
        IFruit fruit = FruitFactory.getInstance("apple");
        fruit.eat();
        //class.forName
        try {
            Class<?> cls1 = Class.forName("java.util.Date");
            Object obj = cls.newInstance(); //等价于 new java.util.Date();
            System.out.println(obj);
            System.out.println(cls.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        System.out.println(date.getClass());
    }
}
