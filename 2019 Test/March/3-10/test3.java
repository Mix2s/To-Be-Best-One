person instanceof Student 如果person对象是由Student实例化返回true
public void test(){
byte b1=1,b2=2,b3,b6,b8;
final byte b4=4,b5=6,b7=9;
b3=(b1+b2);
b6=b4+b5;
b8=(b1+b4);
b7=(b2+b5);
System.out.printl(b3+b6);
}
类型转换
1.两个操作数 有double 另一个也会被转为double 结果也为double
2.来不操作数 float同理
3.两个操作数 前同理  否则 当另一个数位 byte short int char  两个操作数都或被转换为int？？？
4.final 修饰变量类型不会变化
