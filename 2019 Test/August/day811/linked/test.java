package main.linked;

public class test {
    public static void main(String[] args) {
        LinkedImpl il = new LinkedImpl();
        il.addFirst(1);
        il.addFirst(2);
        il.addFirst(3);
         il.addFirst(4);
         il.addFirst(5);
        il.addindex(1,2);
        il.removeAllKey(2);
        il.clear();
        il.display();
    }
}
