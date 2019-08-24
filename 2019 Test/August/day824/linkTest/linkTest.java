package main.linkTest;

public class linkTest {
    class Node{
        private Node random;
        private int value = 0;
        private Node next = null;
        public Node(int value){
            this.value = value;
        }
    }
    public Node newLink(Node node,int key){
        Node cur = new Node(0);
        cur.next = node;         //老节点 遍历节点
        Node header = new Node(0);
        Node tmp = header;       //新链表遍历节点
        while(cur.next!=null){
            if(cur.next.value!=key){
                tmp.next = cur.next; //不相等 符合要求则尾插新的链表
                tmp = tmp.next;
            }else {
                cur = cur.next;
            }
        }
        return header.next;
    }

    public Node merge(Node h1,Node h2){
        Node header = new Node(0);
        Node cur = header;
        if(h1==null&&h2==null){
            return null;
        }
        while(h1!=null&&h2!=null){
            if(h1.value>h2.value){
                cur.next = h2;
                cur = cur.next;
                h2 = h2.next;
            }else{
                cur.next = h1;
                cur = cur.next;
                h1 = h1.next;
            }
        }
        if(h2!=null){
            cur.next = h2;
        }
        if(h1!=null){
            cur.next = h1;
        }
        return header.next;
    }

    public Node copy(Node h1){
        Node node = new Node(0);
        while(h1!=null){
            node.next = new Node(h1.value);
            node = node.next;
            h1 = h1.next;
        }
        return node.next;
    }

    public Node copy2(Node h1){
        Node oldnode = h1;
        Node newnode = null;
        while (oldnode!=null){
            newnode = new Node(oldnode.value);

            oldnode.next = newnode;
            oldnode = oldnode.next;

            newnode.next = oldnode;
            newnode.random = oldnode.random.next;

            newnode = newnode.next;
        }
        while(oldnode!=null){
            Node cur = oldnode.next;
            oldnode.next = cur.next;
            cur.next = cur.next.next;
            oldnode = oldnode.next;
        }
        return null;
    }
}
