package day_2_22;
 /*
  * 1.合并两个排序的链表
思路：定义两个指针，一个指向list1,一个指向List2,
定义一个新链表，List1和list2中哪个小就复制到新链表中。
注意判断list1和list2是否为空！！！ 
*/

public class test5{
	public class ListNode{
		int val;
		ListNode next=null;
		ListNode(int val){
			this.val=val;
		}
	}
	
	public ListNode Merge(ListNode list1,ListNode list2) {
		if(list1==null) {
			return list2;
		}
		if(list2==null) {
			return list1;
		}
		ListNode s=null;
		if(list1.val<list2.val) {
			s=list1;
			s.next=Merge(list1.next,list2);
		}else if(list1.val>=list2.val) {
			s=list2;
			s.next=Merge(list1,list2.next);
		}
		return s;
	}
}

