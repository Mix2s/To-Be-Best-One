class Person{
	private String country;
	private String name;
	private int age;
	public static void setCountry(String country){
		this.country = country;
	}
	public Person(String name){
		this.name = name;
		this.age=age;
		System.out.println(name);
		this.print();  //调用普通方法
	}
	
	public Person(String name,int age){
		this(name);   //调用本类有参构造
		this.age=age;
		this.print();
	}
	
	public void print(){
		System.out.println("在成员方中打印"+this);
	}
	public void setName(String name){
		this.name= name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int i){
		if(i>0&&i<=200){
			this.age=i;
		}else{
			age=0;
		}
	}
	public int Age(){
		return age;
	}
	public String getPersonInfo(){
		return "姓名："+name+"，年龄"+age+",国家"+this.country ;
	}
}
	public class test{
	public static void main(String[] args){
		Person.setCountry("中国");
		Person per1 = new Person("张三",18);
		Person per = new Person("张三",18);
		
		System.out.println(per1.getPersonInfo());
		System.out.println(per.getPersonInfo());
	}
}
