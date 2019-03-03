public class test{
	public static void main(String[] args){
		String a = "a";
		String b ="b";
		if(a==b){
			System.out.println("xx");
		}else{
			System.out.println("yy");
		}
		//输入yy
		
		int x = 1;
		int y = 1;
		if(x==y){
			System.out.println("xx");
		}else{
			System.out.println("yy");
		}
		
		String str1 = "abc";
		String str2 = "abc";
		str1 = "bcd";
		System.out.println(str1 + "," + str2); //bcd, abc
		System.out.println(str1==str2); //false 
		
		String str1 = "abc";
		String str2 = "abc";

		str1 = "bcd";

		String str3 = str1;
		System.out.println(str3); //bcd

		String str4 = "bcd";
		System.out.println(str1 == str4); //true 
		
		String str1 = new String("abc");
		String str2 = "abc";
		System.out.println(str1==str2); //false 
		
		String str1 = "abc";
		String str2 = new String("abc");
		System.out.println(str1==str2); //false 
	}
}
