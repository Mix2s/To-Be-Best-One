interface IMessage{
	public void print();
}
abstract class News implements IMessage{
	public abstract void getNews();//抽象类中的方法前面abstract 不能省略
}
class MessageImpl extends News implements IMessage{
	public void print(){
		System.out.print("zzzzzzz");
	}
	public void getNews(){
		System.out.print("UUUUUUUU");
	}
}
public class Test{
	public static void main(String[] args){
		IMessage  m  = new MessageImpl();
		m.print();
		News news = (News)m;
		news.getNews();
	}
public static void code1(){
	// interface IMessage{
	// abstract void print();
	// }
// class MessageImpl implements IMessage{
	// void print(){
		// System.out.println("zzzz");
	// }
		// IMessage a = new MessageImpl();
		// a.print();
		// /**
		// MessageImpl中的print()无法实现IMessage中的print()
        // void print(){
		// 正在尝试分配更低的访问权限; 以前为public
		// */
}
public static void code(){
		// IMessage m = new MessageImpl();
		// m.print();
		// INews n = (INews)m;
		// System.out.println(n.getNews());
		
	// interface IMessage{
	// String MSG="wudi";
	// void print();
// }
// interface INews{
	// public abstract String getNews();
// }
// class MessageImpl implements IMessage,INews{
	// public void print(){
		// System.out.println(IMessage.MSG);
	// }
	// public String getNews(){
		// return IMessage.MSG;
	// }
// }
}
}
