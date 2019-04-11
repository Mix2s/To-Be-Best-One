package src.javatest;

import java.lang.reflect.Field;

interface IMessage<T>{
    void print(T t);
}
class MyMath{

    public static int add(int x,int y){
        return x+y;
    }
    public static int sub(int x,int y){
        return x-y;
    }
}
class Point{
    //        p.setX(10);
//        p.setY(20);
//        int x = (Integer)p.getX();
//        int y = (Integer)p.getY();

//        p.setX("东京12");
//        p.setY("西京123");
//        String x = (String)p.getX();
//        String y = (String)p.getY();

    //        p.setX(123);
////        p.setY("wudi");
////        String x = (String)p.getX();
////        String y = (String)p.getY();
////        System.out.println(x);
////        System.out.println(y);
    private Object x;
    private Object y;

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }

}
class Point1<T>{
    //        p.setX("1231");
//        p.setY("wuaa");
//        String x = p.getX();
//        String y = p.getY();
//        System.out.println(x);
//        System.out.println(y);

//        p.testMethod1("wudi");
//        String i = p.testMethod2("123");
//        System.out.println(i);

    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public void testMethod1(T t){       //T类型与类的泛型T有关
        System.out.println(t);
    }
    public <T> T testMethod2(T t){      //自身泛型T 与自己定义有关  为了区别泛型方法与类不同泛型名字
        return t;
    }
}
class Message<T extends Object>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
    public void testMethod1(T t){
        System.out.println(t);
    }
}
class MessageImpl<T> implements IMessage<T>{

    @Override
    public void print(T t) {
        System.out.println(t);
    }
}
class MyClass<T,E>{
    private T message;
    private E test;


    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public E getTest() {
        return test;
    }

    public void setTest(E test) {
        this.test = test;
    }
    public void test(T t){
        System.out.println(t);
    }
}

public class pracitve {
    public static void main(String[] args) {
//    Message<String> mess = new Message<>();
//    Message<Integer> mess1 = new Message<>();
//        System.out.println(mess.getClass()==mess1.getClass());
        MyClass<String,Integer> my1 = new MyClass<>();
        Class cls = my1.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field:fields) {
            System.out.println(field.getType());
        }

    }
    public static void fun1(Message<? extends Number> temp){
        //Message<String> mess = new Message<>();
        Message<Integer> mess1 = new Message<>();
        //mess.setMessage("无敌辉");
        mess1.setMessage(99);
        //fun(mess);
        fun1(mess1);
        //    public static void fun(Message<String> temp){
//        System.out.println(temp.getMessage());
//    }
        // 此时使用通配符"?"描述的是它可以接收任意类型，但是由于不确定类型，所以无法修改
        //temp.setMessage(123);
        System.out.println(temp.getMessage());
    }
    public static int add(String msg,int...data){
        System.out.println(add("wudi",1,2,3,4));
        int[] data1 = {1,2,3};
        for (int i:data) {
            System.out.println(i);
        }

        int result=0;
        for (int i = 0; i <data.length; i++) {
            result+=data[i];
        }
        return result;
    }
}


package src.javatest;

import java.lang.reflect.Field;

interface IMessage<T>{
    void print(T t);
}
class MyMath{

    public static int add(int x,int y){
        return x+y;
    }
    public static int sub(int x,int y){
        return x-y;
    }
}
class Point{
    //        p.setX(10);
//        p.setY(20);
//        int x = (Integer)p.getX();
//        int y = (Integer)p.getY();

//        p.setX("东京12");
//        p.setY("西京123");
//        String x = (String)p.getX();
//        String y = (String)p.getY();

    //        p.setX(123);
////        p.setY("wudi");
////        String x = (String)p.getX();
////        String y = (String)p.getY();
////        System.out.println(x);
////        System.out.println(y);
    private Object x;
    private Object y;

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }

}
class Point1<T>{
    //        p.setX("1231");
//        p.setY("wuaa");
//        String x = p.getX();
//        String y = p.getY();
//        System.out.println(x);
//        System.out.println(y);

//        p.testMethod1("wudi");
//        String i = p.testMethod2("123");
//        System.out.println(i);

    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public void testMethod1(T t){       //T类型与类的泛型T有关
        System.out.println(t);
    }
    public <T> T testMethod2(T t){      //自身泛型T 与自己定义有关  为了区别泛型方法与类不同泛型名字
        return t;
    }
}
class Message<T extends Object>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
    public void testMethod1(T t){
        System.out.println(t);
    }
}
class MessageImpl<T> implements IMessage<T>{

    @Override
    public void print(T t) {
        System.out.println(t);
    }
}
class MyClass<T,E>{
    private T message;
    private E test;


    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public E getTest() {
        return test;
    }

    public void setTest(E test) {
        this.test = test;
    }
    public void test(T t){
        System.out.println(t);
    }
}

public class pracitve {
    public static void main(String[] args) {
//    Message<String> mess = new Message<>();
//    Message<Integer> mess1 = new Message<>();
//        System.out.println(mess.getClass()==mess1.getClass());
        MyClass<String,Integer> my1 = new MyClass<>();
        Class cls = my1.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field:fields) {
            System.out.println(field.getType());
        }

    }
    public static void fun1(Message<? extends Number> temp){
        //Message<String> mess = new Message<>();
        Message<Integer> mess1 = new Message<>();
        //mess.setMessage("无敌辉");
        mess1.setMessage(99);
        //fun(mess);
        fun1(mess1);
        //    public static void fun(Message<String> temp){
//        System.out.println(temp.getMessage());
//    }
        // 此时使用通配符"?"描述的是它可以接收任意类型，但是由于不确定类型，所以无法修改
        //temp.setMessage(123);
        System.out.println(temp.getMessage());
    }
    public static int add(String msg,int...data){
        System.out.println(add("wudi",1,2,3,4));
        int[] data1 = {1,2,3};
        for (int i:data) {
            System.out.println(i);
        }

        int result=0;
        for (int i = 0; i <data.length; i++) {
            result+=data[i];
        }
        return result;
    }
}

