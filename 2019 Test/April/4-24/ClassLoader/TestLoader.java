package src.javatest;

class Member{
   @Override
    public String toString(){
       System.out.println("无敌辉");
       return "Member";
   }
}


package src.javatest;

public class TestLoader {
    public static void main(String[] args) throws Exception {
        Class memberClass = Member.class;
        Class memberClass2 =new MyClassLoader().loadData("src.javatest.Member.java");
        System.out.println("mem1"+memberClass.getClassLoader());
        System.out.println("mem2"+memberClass2.getClassLoader());
        System.out.println(memberClass==memberClass2);
    }
    public static void code1(){
        Class classz = MyClassLoader.class;
        System.out.println(classz.getClassLoader());
        System.out.println(classz.getClassLoader().getParent());
        System.out.println(classz.getClassLoader().getParent().getParent());
    }
}

