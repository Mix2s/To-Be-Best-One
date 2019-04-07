package src.com.shuihui.test;

import src.com.shuihui.dao.DoubleLinkedimpl;
import src.com.shuihui.dao.Linkedimpl;

public class Test {
    public static void code(){
        Linkedimpl lin = new Linkedimpl();
        lin.addFirst(1);
        lin.addFirst(2);
        lin.addFirst(3);
        lin.addFirst(3);
        lin.addFirst(3);
        lin.addLast(4);
        lin.addindex(4,5);
        lin.removeAllKey(3);
        lin.display();

    }
    public static void main(String[] args) {
        DoubleLinkedimpl lin = new DoubleLinkedimpl();
        lin.addFirst(1);
        lin.getLength();
        lin.addFirst(2);
        lin.addFirst(2);
        lin.addFirst(2);
        lin.addFirst(3);
        lin.addFirst(3);
        lin.addFirst(3);
        lin.addLast(4);
        lin.addindex(4,5);
        lin.remove(1);
        lin.removeAllKey(3);
        lin.display();
    }
}
