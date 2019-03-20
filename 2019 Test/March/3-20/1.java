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


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.Throwable.Exception;

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

class DynamicProxy implements InvocationHandler{		//动态管理类
	private Object object;	
	public DynamicProxy(Object objet){
		this.object=object;
	}
	public Object invoke(Object proxy,Method method,Object[] args)throws Throwable{
		Object result = method.invoke(object,args);
		return result;
	}
}
public class Test{
	public static void main(String[] args){
			Subject realSubject = new RealSubject();
			DynamicProxy proxy = new DynamicProxy(realSubject);
			ClassLoader classLoder = realSubject.getClass().getClassLoader();
			Subject subject = (Subject)Proxy.newProxyInstance(classLoder,new Class[]{Subject.class},proxy);
			subject.visit();
	}
}
