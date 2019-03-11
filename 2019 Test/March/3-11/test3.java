public class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    } 

}

public class B extends A{
    public String show(B obj){
        return ("B and B");
    }
    
    public String show(A obj){
        return ("B and A");
    } 
}

public class C extends B{

}

public class D extends B{

}

public class Test {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        
        System.out.println("1--" + a1.show(b));    
        System.out.println("2--" + a1.show(c));		
        System.out.println("3--" + a1.show(d));
        System.out.println("4--" + a2.show(b));
        System.out.println("5--" + a2.show(c));
        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));      
    }
}
// class Wine {
    // private String name;
    
    // public String getName() {
        // return name;
    // }

    // public void setName(String name) {
        // this.name = name;
    // }

    // public Wine(){
    // }
    
    // public String drink(){
        // return "喝的是 " + getName();
    // }
    
    // /**
     // * 重写toString()
     // */
    // public String toString(){
        // return null;
    // }
// }

// class JNC extends Wine{
    // public JNC(){
        // setName("JNC");
    // }
    
    // /**
     // * 重写父类方法，实现多态
     // */
    // public String drink(){
        // return "喝的是 " + getName();
    // }
    
    // /**
     // * 重写toString()
     // */
    // public String toString(){
        // return "Wine : " + getName();
    // }
// }

// class JGJ extends Wine{
    // public JGJ(){
        // setName("JGJ");
    // }
    
    // /**
     // * 重写父类方法，实现多态
     // */
    // public String drink(){
        // return "喝的是 " + getName();
    // }
    
    // /**
     // * 重写toString()
     // */
    // public String toString(){
        // return "Wine : " + getName();
    // }
// }

// public class Test {
    // public static void main(String[] args) {
        // //定义父类数组
        // Wine[] wines = new Wine[2];
        // //定义两个子类
        // JNC jnc = new JNC();
        // JGJ jgj = new JGJ();
        
        // //父类引用子类对象
        // wines[0] = jnc;
        // wines[1] = jgj;
        
        // for(int i = 0 ; i < 2 ; i++){
            // System.out.println(wines[i].toString() + "--" + wines[i].drink());
        // }
        // System.out.println("-------------------------------");

    // }
// }
// public class Test {
    // public static void main(String[] args) {
        // Wine a = new JNC();
        // a.fun1();
    // }
// }
// class Wine {
    // public void fun1(){
        // System.out.println("Wine 的Fun.....");
        // fun2();
    // }
    
    // public void fun2(){
        // System.out.println("Wine 的Fun2...");
    // }
// }
// class JNC extends Wine{
    // /**
     // * @desc 子类重载父类方法
     // *        父类中不存在该方法，向上转型后，父类是不能引用该方法的
     // * @param a
     // * @return void
     // */
    // public void fun1(String a){
        // System.out.println("JNC 的 Fun1...");
        // fun2();
    // }
    
    // /**
     // * 子类重写父类方法
     // * 指向子类的父类引用调用fun2时，必定是调用该方法
     // */
    // public void fun2(){
        // System.out.println("JNC 的Fun2...");
    // }
// }
