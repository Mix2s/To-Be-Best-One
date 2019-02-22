package day_2_22;
/*
 * 
*分析：设定两个指针，min指向和为n的连续正数序列的最小值，
max指向和为n的连续正数序列最大值。sum表示真正的和。
*初始情况下,min、max和sum 都指向1.
*当sum小于n时，max++；
*当sum大于n时，min++;
*当sum等于n时，输出整个序列
 */

/*
 * 给定一个排好序的链表，删除链表中重复的结点，返回链表头指针。
 *分析：(1)链表中重复的结点不需要保留一个，要全部删除。
 *(2)因为相同的结点全部要删除，所以我们设定三个指针，
 *node指向当前节点,prev指向前驱，还有一个指向后继结点。
 *一旦遇到node和后继结点相等，就node++,知道没有重复的再移动prev.
 *(3)注意：头结点也可能有重复，
 *所以也可能被删除，所以需要定义一个root指向头结点。
 */
public class test1 { 
	//结点定义包括当前结点的值和next指向
	private static class ListNode{
		private int val;
		private ListNode next;
		public ListNode() {
			
		}
		public ListNode(int val) {
			this.val=val;
		}
		public String toString() {
			return val+"";
		}
	}
	//删除节点的函数
	public static ListNode delete(ListNode head) {
		if(head==null) {
			return null;
		}
		if(head.next==null) {
			return head;
		}
		//定义一个临时头节点，头节点可能被会删除
		ListNode root=new ListNode();
		root.next=head;
		ListNode prev=root;
		ListNode node=head;
		while(node!=null&&node.next!=null) {
			if(node.val==node.next.val) {
				//若有连续的相同结点，则node要一直++
				while(node.next!=null&&node.next.val==node.val) {
					node=node.next;
					prev.next=node.next;
				}
				}else {
					prev.next=node;
					prev=prev.next;
			}
			node=node.next;
		}
		return root.next;
	}
	//打印删除后的结果
	private static void print(ListNode head) {
		while(head!=null) {
			System.out.println(head+"->");
			head=head.next;
		}
		System.out.println("null");
	}
public static void getAns(int n) {
	int min=1;
	int sum=1;
	int max=1;
	while(min<=n/2+1) {
		if(sum==n) {
			for(int k=min;k<=max;k++) {
				System.out.println(k+"");
			}
			System.out.println();
			sum=sum-min;
			min++;
			max++;
			sum=sum+max;
		}
		if(sum>n) {
			sum=sum-min;
			min++;
		}else {
			max++;
			sum=sum+max;
		}
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getAns(15);
		
		//按照结点的定义新疆一个链表
		ListNode n1=new ListNode(1);
		ListNode n2= new ListNode(1);
		ListNode n3= new ListNode(2);
		ListNode n4= new ListNode(2);
		ListNode n5= new ListNode(2);
		ListNode n6= new ListNode(3);
		ListNode n7= new ListNode(5);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		n7.next=null;
		
		//调用delete函数 传入你的值 当成结点
		ListNode result=delete(n1);
		print(result);
	}

}
