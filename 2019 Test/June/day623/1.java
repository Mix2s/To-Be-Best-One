package com.coole;

import lombok.Data;

import java.io.*;
import java.util.*;

@Data
class Person{
    private String name;
    private Integer age;
    private Boolean gender;

    public Person(String name, Integer age, Boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age) &&
                Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}
public class test_properties {
    public static void main(String[] args) throws IOException {
            List<Person> personList = new ArrayList<>();
            personList.add(new Person("hui",19,true));
        personList.add(new Person("wang",20,false));
        personList.add(new Person("123i",19,true));
        System.out.println(personList.contains(new Person("hui",19,false)));
        System.out.println(personList.contains(new Person("hui",20,true)));
        System.out.println(personList.contains(new Person("wang",19,true)));
        System.out.println(personList.contains(new Person("hui",19,true)));
    }

    private static void code2() {
        List<String> list = new ArrayList<>();
        System.out.println(list.size()+"   "+list.isEmpty());
        list.add("wudi");
        list.add("bit");
        System.out.println(list.contains("wudi"));
        String str = "wudihui";
        String str1 = "wudi";
        System.out.println(str.contains("did"));
        System.out.println(list.get(0));
        Collection<String> coo = new ArrayList<>();
        list.add("wudud");
        list.add("hui");
        Object[] result = list.toArray();
        System.out.println(Arrays.toString(result));
    }

    private static void code() throws IOException {
        Properties properties = new Properties();
        InputStream in = test_properties.class.getClassLoader().getResourceAsStream("test.properties");
        properties.load(in);
        System.out.println(properties.getProperty("cc"));

        /*Properties properties = new Properties();
        properties.load(new FileInputStream(new File("D:\\\\workspace\\\\wanghui\\\\src\\\\main\\\\resources\\\\test.properties")));
        System.out.println(properties.getProperty("cc"));

        Properties properties = new Properties();
        properties.setProperty("aa","AA");
        properties.setProperty("bb","BB");
        properties.setProperty("cc","CC");
        File file = new File("D:\\workspace\\wanghui\\src\\main\\resources\\test.properties");
        properties.store(new FileOutputStream(file),"testproties");*/
    }
}
