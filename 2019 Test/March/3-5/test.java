class GameObject{
	int life;
	public  GameObject(int life){
		super();
		this.life=life;
	}
	public int life_reduce(int ai_reduce){
		life=life-ai_reduce;
		return life;
	}
	public int life_add(int ai_add){
		life=life+ai_add;
		return life;
	}
}
class Creature extends GameObject {
	String mc;
	int attack;	
	
	public Creature(String mc, int attack,int life) {
		super(life);
		this.mc = mc;
		this.attack = attack;
	}
	public void move() {
		System.out.println(mc+"在移动！");
	}
	public void normal_attack() {
		System.out.println(mc+"在普通攻击！");
	}	
}

class Hero extends Creature{
	
	String name;
	String skill;
	
	public Hero(String name,String skill,String mc, int attack,int life) {
		super(mc,attack,life);
		this.name = name;
		this.skill = skill;
	}
 
	public void skill_attack(){		
		System.out.println(mc + name + "用"+skill+"攻击!");
	}
	
	public void eat_food(int food){
		life_add(food);
		System.out.println(mc + name + "吃了"+food + "血，当前血量"+life);
	}
}
public class test{
	  public static void main(String[] args) {
		  
		 Hero heroDfs = new Hero("甘道夫","暴风雪","大法师",14,450);				 
		 Creature fishman=new Creature("小鱼人",5,200);	
		 Creature turtle=new Creature("大海龟",20,2000);
		 
		 heroDfs.skill_attack();		 
		 fishman.life_reduce(10);
		 System.out.println(fishman.mc + "当前血量"+fishman.life);
		 turtle.life_reduce(20);
		 System.out.println(turtle.mc + "当前血量"+turtle.life);			 
		 turtle.normal_attack();
		 fishman.normal_attack();
		 heroDfs.life_reduce(5);
		 System.out.println(heroDfs.name + "当前血量"+heroDfs.life);	
		 heroDfs.life_reduce(5);
		 System.out.println(heroDfs.name + "当前血量"+heroDfs.life);	
		 
	   }
	}
