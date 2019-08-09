package main.treePackge.Linktree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(1);
        a.add(2);
        b.add(1);
        b.add(null);
        b.add(2);
        System.out.println(b.equals(a));
        /*int[] arr = new int[]{1,2,3,4,5,6,7};
        Heap head = new HeapImpl();
        head.initHeap(arr);
        head.show();
        head.pushHeap(10);
        head.show();
        System.out.println();
        head.popHeap();
        head.show();*/
    }
}
