interface Subject{
	void visit();
}
class RealSubject implements Subject{
	private String name = "RealSubject 实现类";
	public void visit(){		//覆写接口方法
		System.out.println(name);
	}
}
class ProxySubject implements Subject{			//代理类
	private Subject subject;
	public ProxySubject(Subject subject){
		this.subject=subject;
	}
	public void visit(){
		subject.visit();
	}
}
public class Test{
	public static void main(String[] args){
		ProxySubject subject = new ProxySubject(new RealSubject());
		subject.visit();
	}
}
