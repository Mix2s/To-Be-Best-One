package main.linked;

public class LinkedImpl implements ILinked{
    private Node head;
    class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    @Override
    public void addFirst(int data) {
        //头插法
        Node node = new Node(data);
        if(this.head == null){
            //第一次插入
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        if(cur==null){
            this.head = node;
        }else{
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    private Node serchIndex(int index){
        checkIndex(index);
        if(index==0){
            return null;
        }
        int count = index;
        Node cur = this.head;
        while(count>1){
            count--;
            cur = cur.next;
        }
        return cur;
    }
    private void checkIndex(int index){
        if(index<0||index>getLength()){
            throw new IndexOutOfBoundsException("下标不合法");
        }
    }
    @Override
    public boolean addindex(int index, int data) {
        Node node = new Node(data);
        Node cur = serchIndex(index);
        if(cur==null){
            node.next = this.head;
            this.head = node;
        }else{
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node node = this.head;
        while(node!=null){
            if(node.data==key){
                return true;
            }else{
                node = node.next;
            }
        }
        return false;
    }


    @Override
    public int remove(int key) {
        Node pre = this.head;
        Node cur = this.head.next;
        if(cur==null){
            if(pre.data==key){
                return key;
            }
        }
        while(cur!=null && pre!=null){
           if(cur.data==key){
               pre.next = cur.next;
               return key;
           }
           cur = cur.next;
           pre = pre.next;
        }
        return -1;
    }

    @Override
    public void removeAllKey(int key) {
        Node cur = this.head;
        int count = 0;
        while(cur!=null){
            if(cur.data==key){
                count++;
            }
            cur = cur.next;
        }
        while(count>0){
            remove(key);
            count--;
        }
    }

    @Override
    public int getLength() {
       int len = 0;
       Node node = this.head;
       while(node!=null){
           len++;
           node = node.next;
       }
       return len;
    }

    @Override
    public void display() {
        Node node = this.head;
        if(node==null){
            System.out.println("NULL");
        }
        while(node!=null){
            System.out.print(node.data+" ");
            node = node.next;
        }
    }

    @Override
    public void clear() {
        this.head = null;
    }
}
