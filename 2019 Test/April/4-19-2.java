package src.com.shuihui.test;

import java.lang.reflect.Field;

class Person{
    private String name;
    public int age;
}
class Student extends Person{
    private String school;
}
public class Test{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> cls = Person.class;
        Object obj = cls.newInstance();
        Field name = cls.getDeclaredField("name");
        System.out.println(name.getType());
        System.out.println(name.getType().getName());
        System.out.println(name.getType().getSimpleName());
    }
    public static void code1() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> cls = Person.class;
        Object obj = cls.newInstance();
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);   //取消封装
        name.set(obj,"wudi");
        System.out.println(name.get(obj));
        Class<?> cls1 = Person.class;
        Object obj2 = cls.newInstance();
        Field nameField = cls.getDeclaredField("name");
        nameField.set(obj,"wudi");
        System.out.println(nameField.get(obj));
        Class<?> cls3 = Student.class;
        {
            Field[] fie = cls.getFields();  //获得类中的全部公有属性包括继承的父类
            for(Field i:fie){
                System.out.println(i);
            }
        }
        System.out.println("标记+++++++++");
        {
            Field[] fie = cls.getDeclaredFields();  //拿到本类属性
            for(Field i:fie){
                System.out.println(i);
            }
        }
    }
}
