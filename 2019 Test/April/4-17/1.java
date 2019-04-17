package src.com.shuihui.test;
interface IMessage{
    public void wudi();
}
public class Test {
    public static void main(String[] args) {
        IMessage message = new IMessage() {
            @Override
            public void wudi() {
                System.out.println("wudi hui");
            }
        };
        message.wudi();
        IMessage message1 = ()-> System.out.println("wuduiaa");
        message1.wudi();
        }
    public static void code4(){
        /*
            interface IMessage{
    public default void fun(){      //追加普通方法，有方法体
        System.out.println("Hello wudi");
    }
    public static IMessage getInstance(){   //可以直接接口名字调用
        return new MessageImpl();
    }
    public void print();
}
class MessageImpl implements IMessage{
    @Override
    public void print() {
        System.out.println("HEllow MessageImpl");
    }
}
         */
    }
    public static void code3(){
        /*
          Person person = new Person();
      person.fun();
      person = new Person("");
      enum Sex{
    MALE,FEMALE;
}
class Person{
    @Deprecated
    public Person(){

    }
    public Person(String name){

    }
    @Deprecated
    public void fun(){

    }
}
         */
    }
    public static void code2(){
        /*
          switch (Sex.MALE){
            case MALE:
                System.out.println("男人");
           Person per = new Person("张三",20,Sex.MALE);
     System.out.println(per);
            enum Sex{
    MALE("男"),FEMALE("女人");
    private String title;
    private Sex(String title){
        this.title=title;
    }
    @Override
    public String toString() {
        return this.title;
    }
}
class Person{
    private String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
         */
    }
    public static void code1(){
        /*
        interface IColor{
    public String getColor();
}
enum Color implements IColor{
        RED("红色"),GREEN("绿色"),BULE("l蓝色");
    private String title;
      private Color(String title){
         this.title=title;
     }
        @Override
    public String toString() {
            return this.title;
        }
    @Override
    public String getColor() {
        return this.title;
    }
}
         */
    }
    public static void code(){
         /*
        System.out.println(Color.BULE);
         System.out.println(Color.BULE.ordinal()+'='+Color.BULE.name());
         for (Color temp:Color.values()) {
            System.out.println(temp.ordinal()+'='+temp.name());
        }

    enum Color{
        RED,GREEN,BULE
    }

    enum Color{
        RED("红色"),GREEN("绿色"),bule("l蓝色");
        private String title;
        private Color(String title){
            this.title=title;
        }

        @Override
        public String toString() {
            return this.title;
        }
    }
    */
    }
}
