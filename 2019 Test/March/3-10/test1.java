class Person{
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
}


class Student extends Person{
	
		public void fun(){
		System.out.println(getName());
	}
	// public Student(){
		// super();
		// System.out.println("Studentchansheng");
	// }
	
	// public Person(){
		// System.out.println("Personchansheng");
	// }
}
public class test{
	public static void main(String[] args){
		Student student = new Student();
		student.setName("asdasd");
		System.out.println(student.getName());
		student.fun();
	}
	
	public static void code(){
		// Student student = new Student();
	// student.setName("Steasda");
	// student.setAge(100);
	// student.setSchool("wujabw");
	// System.out.println("姓名："+student.getName()+"，年龄："+student.getAge()+"学校："+student.getSchool());
		// class Person{
	// private String name;
	// private int age;
// public String getName() {
	// return name;
	// }
// public void setName(String name) {
	// this.name = name;
	// }
// public int getAge() {
	// return age;
	// }
// public void setAge(int age) {
	// this.age = age;
		// }
	// }
	
// class Student extends Person{
	// private String school;
	// public String getSchool(){
		// return school;
	// }
	// public void setSchool(String school){
		// this.school = school;
	// }
// }
	}
}
