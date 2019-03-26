public class TestObject{

    public static void code1(){
         //1.引用数据类型
        //2.JDK提供的 String 
        //3.Person Car Student 用户自定义
        //4.JDK Object 所有的类的父类
        String str  =new String("Hello World");
        Person person = new Person("张三",22);
        Car car = new Car();
        //Student stu = new Student();
        
        print(str);
        print(person);
        print(car);
        //print(stu);
    }

    
    public static void code2(){
       Person p1  = new Person("zhangsan",18);
       Person p2  = new Person("zhangsan",19);
       System.out.println(p1==p2);//false
       System.out.println(p1.equals(p2));//?
    }
    
    public static void code3(){
        
        /*
        Object object = new int[]{1,2,3};
        int[] intArray  = (int[])object;
        for(int i=0; i<intArray.length; i++){
            System.out.println(intArray[i]);
        }
        */
        /*
        A a = new B();
        Object obj  = a;
        */
        /*
        Object obj = 15; //int 基本数据类型
        int  a = (int)obj;
        */
        
        /*
        int a =10;
        //包装了一下  装箱
        IntWapper intWapper = new IntWapper(a);
        Object obj = intWapper;
        IntWapper intWapper2 =(IntWapper) obj;
        //拆除包装   拆箱
        int b = intWapper2.getValue();
        */
        
        /*
        Integer num = new Integer(25);//装箱
        System.out.println(num);
        int  value = num.intValue(); //拆箱
        System.out.println(value);
        */
        
        /*
        Integer a = 5; //自动装箱
        System.out.println(a++); //自动拆箱
        */
        
        //1. equals int value 
        //2. new Integer()  == 比对象地址
        //3. 自动装箱  隐式new == 比对象地址
        //4. valueOf()  15 true  666 false
        //默认情况 int [-128,127] valueOf获取Integer对象缓存对象
        Integer num1 = new Integer(10) ; 
        Integer num2 = new Integer(10) ; 
        
        Integer num3 = Integer.valueOf(15);
        Integer num4 = Integer.valueOf(15);
        Integer num5 = Integer.valueOf(666);
        Integer num6 = Integer.valueOf(666);
        
        Integer num7 = 666;
        Integer num8 = 666;
        
        System.out.println(num1 == num2); //false
        System.out.println(num1 == new Integer(10)); //false
        System.out.println(num1.equals(new Integer(10))); //true
        System.out.println(num1 == num3); //false
        System.out.println(num3 == num4); //true
        System.out.println(num5 ==num6); //false 
        System.out.println(num5 == num7); //false
        System.out.println(num7 == num8);//false
    }
    
    public static void main(String[] args){
       
       /*
       String str = "ab123c";
       Integer intValue = Integer.parseInt(str);
       System.out.println(intValue);
       */
       /*
       String str = "123.14abc";
       Double doubleValue = Double.parseDouble(str);
       System.out.println(doubleValue);
       */
       //true false 
       //True False 
       System.out.println(Boolean.parseBoolean("true"));
       System.out.println(Boolean.parseBoolean("false"));
       //str 忽略大小写等于true
       System.out.println(Boolean.parseBoolean("False"));
       System.out.println(Boolean.parseBoolean("True"));
       System.out.println(Boolean.parseBoolean("abc"));
       System.out.println(Boolean.parseBoolean("1234"));
       
       //基本数据类型转字符串
       String str1 = 1+"";
       String str2 = String.valueOf(1);
       
    }
    
    public static void print(Object object){
        System.out.println(object);
        
    }

}

class IntWapper{
    
    private int value;
    
    public IntWapper(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
}

interface A{
    
}

class B implements A{
    
}

class Person{
   private String name;
   private int age;

   public Person(String name, int age){
       this.name = name;
       this.age= age;
   }   
   
   //Person继承了Object 覆写toString println打印对象时调用toString   
   public String toString(){
       return "name:"+this.name+" age:"+this.age;
   } 
   
   public String getName(){
       return this.name;
   }
   
   public int getAge(){
       return this.age;
   }
    
    
   //equals在字符串中比内容
   //Person类中equals比name 
   public boolean equals(Object that){
       if(this == that){
           return true;
       }
       if(that instanceof Person){
           Person thatPerson = (Person)that;
           return this.name.equals(thatPerson.getName());
           //&&this.age==thatPerson.getAge();
           
       }
       return false;
   }
    
   
}

class Car{
    
}

class Student extends Person{
    
    public Student(String name, int age){
        super(name,age);
    }
    
}
