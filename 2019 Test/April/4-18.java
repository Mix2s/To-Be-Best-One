package src.com.shuihui.test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        super();
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
interface IMessage{
    public void print();
}
interface IMessage2{
    public void print();
}
interface IMessage3{
    public String info();
}
interface IMath{
    public int add(int x,int y);
}
interface IUtil<P,R>{
    public R switchPara(P p);
}
interface IUtil1<R>{
    public R switchPara();
}
interface IUtil2<R,P>{
    public R compare(P p1,P p2);
}
interface IUtil3<P1,P2,R>{
    R createObject(P1 p1,P2 p2);
}

public class Test {
    public static int charsCountA(char[] chars){
        int i = 0;
        for (char c:chars
             ) {
            if(c=='A'){
                i++;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        Function<Integer,String> fun = String::valueOf;
        System.out.println(fun.apply(1231));
        Supplier<String> sup = "hello"::toUpperCase;
        System.out.println(sup.get());
        Consumer<String> con = System.out::println;
        con.accept("wudi");
        Predicate<String> pre = "123123123"::startsWith;
        System.out.println(pre.test("22"));
    }
    public static void code1(){
        /*
        Function<Integer,String> fun = String::valueOf;
        Function<String,Integer> fun1 = String::length;
        Function<char[],Integer> fun3 = (chars)->{
            int i=0;
            for (char c:chars
                 ) {
                if(c=='A'){
                    i++;
                }
            }
            return i;
        };
        IUtil3<String,Integer,Person> iu = Person::new;
        System.out.println(iu.createObject("wudi",12));

        IUtil3<String,Integer,Person> iu1 = (p1,p2)->{
            return new Person(p1,p2);
        };
        Person person = iu1.createObject("wudi",14);
        System.out.println(person);
           IUtil2<Integer,String> iu = (p1,p2)->{
          return p1.compareTo(p2);
      };
      int com = iu.compare("hello","wudi");
        System.out.println(com);
        IUtil2<Integer,String> iu1 = String::compareTo;
        System.out.println(iu1.compare("wudi","shuiai"));
          IUtil1<String> iUtil = ()->{
          return "hello";
      };
        System.out.println(iUtil.switchPara());
        IUtil1<String> iUtil1 = "hello"::toUpperCase; //转大写
        System.out.println(iUtil1.switchPara());
          IUtil<Integer,String> iUtil = String::valueOf;
        System.out.println(iUtil.switchPara(12));
          IUtil<Integer,String> iUtil = (i)->{
            return String.valueOf(i);
        };
        System.out.println(iUtil.switchPara(1));
          IMath math = (a,b)->{
        return a+b;
    };
        System.out.println(math.add(4,5));
             IMath math = (x,y)->{
           return x+y;
       };
        System.out.println(math.add(1,2));
            IMath math =  new IMath() {
                @Override
                public int add(int x, int y) {
                    return x+y;
                }
            };
        System.out.println(math.add(1,2));
          IMessage3 message=()->{
        return "wudi"+"shuiahui";
    };
        System.out.println(message.info());
          IMessage2 message = ()->{
         String a = "hello";
         String b = "wudi";
         return  a+b;
     };
        System.out.println(message);
         IUtil<Integer,String> iu = String::valueOf;
      String str = iu.switchPara(1000);
        System.out.println(str.length());
         IMessage message = ()->{
         System.out.println("wudi");
         System.out.println("shuihui");
     };
     message.print();
         */
    }
    public static void covert(IUtil<Integer,String> iUtil){
        System.out.println(iUtil.switchPara(20));
    }
}
