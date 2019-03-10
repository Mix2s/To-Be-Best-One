// class Person{
	// public void fun(){
		// this.print();
	// }
	// private void print(){
		// System.out.println("1 Person print方法");
	// }
// }
	// // public void print(){
		// // System.out.println("1.Person print方法");
	// // }
// // }
// class Student extends Person{
	// public void print(){
		// System.out.println("2 Student print方法");
	// }
// }

class Person{
	public String info = "wudi";
	public void print(){
		System.out.println("1 1asda");
	}
}
class Student extends Person{
	public String info = "wudia";
	public void print(){
		System.out.println(super.info);
		System.out.println(this.info);
		// super.print();
		// System.out.println("12312");
	}
}
public class test{
	public static void main(String[] args){
		Person per = new Student();
		per.print();
	}
}
