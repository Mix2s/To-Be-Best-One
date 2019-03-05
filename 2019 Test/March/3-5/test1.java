 class Person{
	private String name;
	private int age;
	
	Person(){
		System.out.println("A:name="+name+"::age"+age);
	}
	Person(String n){
		name = n;
		System.out.println("B:name="+name+"::age"+age);
		cry();
	}
	
	Person(String n,int a){
		name=n;
        age=a;
        System.out.println("C:name="+name+":::age="+age);
	}
	void cry(){
		System.out.println("cRY。。。。。。。。。。");
	}
 }
public class test{
	public static void main(String[] args)
    {
        Person p1=new Person();
        Person p2=new Person("lishi");
        Person p3=new Person("lishi",10);
    }
public class test{
	public String name;
	public int age;
	public static String sex="男";
	public test(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void say(){
		System.out.println("My name"+name+"My year"+age+"岁");
	}
	 public static void main(String args[]){
        test obj = new test("alex",25);
        obj.say();
        System.out.println("我是"+sex+"生");
//        System.out.println("我今年"+age+"岁");
    }
	 public String name;
    public int age;
    public static String sex="男";
 
    public test(String name1, int age){
        this.name = name1;
        this.age = age;;
    }
 
    public void say(){
        System.out.println("我的名字是"+name+",我今年"+age+"岁.");
//        System.out.println("我的名字是"+name1+",我今年"+age+"岁.");
    }
 
    public static void main(String args[]){
        test obj = new test("alex",25);
        obj.say();
        System.out.println("我是"+sex+"生");
    }
	
	   public static void main(String[] args) {
        int a; // 系统会给一个初始值为0
        float b;
    }

    public static int f(int a){
        int b;
        return b; // 报错：initialize variable，要求给一个初始值
    }
}
 
