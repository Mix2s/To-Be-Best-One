package src.com.shuihui.test;

import src.com.shuihui.dao.Linkedimpl;

public class Test {
    public static void main(String[] args) {
        Linkedimpl lin = new Linkedimpl();
        lin.addFirst(12);
        lin.addFirst(22);
        lin.addFirst(15);
        lin.addLast(45);
        lin.addindex(2,120);
        lin.display();
        System.out.println(lin.contains(2));
    }
}
