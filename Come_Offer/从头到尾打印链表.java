import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(listNode!=null){
            list.add(0,listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
} 
本解的思路：创建一个ArrayList 数组，存在于库函数中。遍历传入的链表的每一个通过ArrayList的特性 相似于顺序表的头插法最终遍历结束实现
      
