package src.javatest;

import java.lang.reflect.Field;

class Person{
    private String name;
}
class EmpAction{
    private Emp emp = new Emp();
    public void setValue(String value) throws Exception {
        BeanOperation.setBeanValue(this,value);
    }
    public Emp getEmp(){
        return emp;
    }
}
class Emp{
    private String ename;
    private String job;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
        String value = "emp.ename:yuisama|emp.job:Java Coder";
        EmpAction empAction = new EmpAction();
        empAction.setValue(value);
        System.out.println(empAction.getEmp());
    }
    public static void code1() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> cls = Person.class;
        Object obj = cls.newInstance();
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(obj,"wudi");
        System.out.println(name.getType().getName());
        System.out.println(name.getType().getSimpleName());
        System.out.println(name.get(obj));
    }
}
