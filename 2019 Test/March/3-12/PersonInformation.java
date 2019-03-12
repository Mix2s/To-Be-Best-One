public class WorkTest{
	private String name;
	private String post;
	private boolean sex;
	private int age;
	private String tel;
	private String adress;
	
	public WorkTest(){
		
	}
	public WorkTest(String name,String post,boolean sex,int age,String tel,String adress){
		this.name=name;
		this.post=post;
		this.sex=sex;
		this.age=age;
		this.tel=tel;
		this.adress=adress;
	}
	
	public String toString(){
		return "name："+this.name+"\t"+
		"post: "+this.post+"\t\n"+
		"sex: "+(this.sex?"female":"male")+"\t"+
		"age: "+this.age+"\t\n"+
		"tel: "+this.tel+"\t"+
		"adress: "+this.adress;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setPost(String post){
		this.post = post;
	}
	public String getPost(){
		return this.post;
	}
	
	public void ifSex(boolean sex){
		this.sex=sex;
	}
	public boolean getSex(){
		return this.sex;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return this.age;
	}
	
	public void setTel(String tel){
		this.tel = tel;
	}
	public String getTel(){
		return this.tel;
	}
	
	public void setAdress(String adress){
		this.adress = adress;
	}
	public String getAdress(){
		return this.adress;
	}
	
public class WorkTest_ch extends WorkTest{
	public WorkTest_ch(String name,String post,boolean sex,int age,String tel,String adress){
		super(name,post,sex,age,tel,adress);
	}
	public String toString(){
		return "姓名："+this.getName()+"\t"+
		"代号: "+this.getPost()+"\t\n"+
		"性别: "+this.getSex()+"\t"+
		"年龄: "+this.getAge()+"\t\n"+
		"电话: "+this.getTel()+"\t"+
		"地址: "+this.getAdress();
	}
}
	public static void main(String[] args){
		WorkTest wo = new WorkTest("li","wo",true,18,"zz","ada");
		System.out.println(wo);
	}
}
