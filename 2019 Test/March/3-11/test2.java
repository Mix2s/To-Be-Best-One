class MyClass {
    public final double i = Math.random();
    public static double j = Math.random();
}
public class Test{
public static void main(String[] args){
		 MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
        System.out.println(myClass2.j);
}
public static void code2(){
	// class Person {
 
    // public static void prt(String s) {
        // System.out.println(s);
    // }
 
    // Person() {
        // prt("A Person.");
    // }
 
    // Person(String name) {
        // prt("A person name is:" + name);
 
    // }
// }
// public class Chinese extends Person {
    // Chinese() {
        // super(); // 调用父类构造函数（1）
        // prt("A chinese.");// (4)
    // }
 
    // Chinese(String name) {
        // super(name);// 调用父类具有相同形参的构造函数（2）
        // prt("his name is:" + name);
    // }
 
    // Chinese(String name, int age) {
        // this(name);// 调用当前具有相同形参的构造函数（3）
        // prt("his age is:" + age);
    // }
}
public static void code1(){
	// class Person{
	// public void print(){
		// System.out.println("1 Person 方法");
	// }
// }
// class Student extends Person{
	// public void print(){
		// System.out.println("2.[Student]类的p");
	// }
// }
}
public static void code(){
	
	// class Person{
	// String name;
	// int age;
	// String sex;
	// Person(){
		// System.out.println("Person Constract");
	// }
// }
// public class Test extends Person{
	// private Test test;
	// Test(){
			// System.out.println("Test Constractor");
		// }
// }
 }
} 
