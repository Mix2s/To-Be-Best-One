package day1;

import java.util.Random;



class Tree{
	int height;
	Tree(){
		System.out.println("Planting a seeding");
		height = 0;
	}
	Tree(int initalHeight){
		height = initalHeight;
		print("Creating new Tree that is"+height+"feet tall");
	}
	void info() {
		print("Tree is"+height+"feel");
	}
	void info(String s) {
		print(s+"Tree is"+height+"feet");
	}

//class Rock{
//	Rock(int i){
//		System.out.println("Rock"+i);
//	}
//}
private void print(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}
}

class Bird{
	Bird(int i){
		
	}
}
class Banana{
	void peel(int i) {
		System.out.println("///////");
	}
}

class Leaf{
	int i = 0;
	Leaf increment() {
		i++;
		return this;
	}
	void print() {
		System.out.println("i="+i);
	}
}
class Person{
	public void eat(Apple apple) {
		Apple peeled = apple.getPeeled();
		System.out.println("标记1");
				System.out.println("wudi");
	}
}
class Peeler{
	static Apple peel(Apple apple) {
		System.out.println("标记2");
		return apple;
	}
}
class Apple{
	Apple getPeeled() {
		System.out.println("标记3");
		return Peeler.peel(this);
	}
}


class Flower{
	int peltalCount = 0;
	String s = "wufawutian";
	Flower(int petals){
		peltalCount = petals;
		System.out.println("标记1="+peltalCount);
	}
	Flower(String ss){
		System.out.println("标记2 = "+peltalCount);
		s=ss;
	}
	Flower(String s,int petals){
		this(petals);
		
		this.s=s;
		System.out.println("标记3");
	}
	Flower(){
		this("hi",47);
		System.out.println("标记4");
	}
	void printPetalCount() {
		System.out.println("标记5"+peltalCount);
	}
	
}
public  class day_1 {
	

	
?

public static void main(String[] args) {
	Flower x = new Flower();
	x.printPetalCount();

	for(int i=0;i<10;i++){
		f[i]=rand.nextFloat();
		for(float x:f) {
			System.out.println(x);
		}
	}
	for(int i=1,j=i+10;i<5;i++,j=i*2) {
		System.out.println("i="+i+"j="+j);
	}
	for(char c=0;c<128;c++) {
		if(Character.isLowerCase(c)) {
			System.out.println("value  "+(int)c+"Characer  "+c);	
		}
	}
	while(condition()) {
		System.out.println("IUnside'while'");
	}
	System.out.println("Exited'while'");
		test(5,6);
		System.out.println(result);
		
