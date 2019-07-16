package daydayup;
class ListNode{
    int val = 0;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}
public class day6132 {
    public static void main(String[] args) {
        ListNode a = new ListNode(5);

        ListNode b = new ListNode(5);
        plusAB(a,b);
    }
    public static ListNode plusAB(ListNode a, ListNode b) {
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        ListNode add = new ListNode(0);
        ListNode addHead = add;
        int sum = 0;
        while(a!=null||b!=null||sum!=0){
            if(a!=null){
                sum += a.val;
                a = a.next;
            }
            if(b!=null){
                sum += b.val;
                b = b.next;
            }
            addHead.next = new ListNode(sum%10);
            sum/=10;
            addHead = addHead.next;
        }
        return add.next;
    }
}
