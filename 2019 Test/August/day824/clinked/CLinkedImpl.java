package main.clinked;

public class CLinkedImpl implements CILinked{
    class  Node{
        private Node next;
        private int data;

        public Node(){
            this.data = -1;
        }
        public Node(int data){
            this.data = data;
        }
    }

    private Node head;

    public CLinkedImpl(){
        this.head = new Node();
        this.head.next = this.head;
    }
    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head.next;
        this.head.next = node;
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        while(cur.next!=this.head){
            cur = cur.next;
        }
        node.next = this.head;
        cur.next = node;
    }

    private void checkIndex(int index){
        if(index<0||index>getLength()){
            throw new IndexOutOfBoundsException("下标非法");
        }
    }

    @Override
    public boolean addindex(int index, int data) {
        Node node = new Node(data);
        Node cur = this.head;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        node.next = this.head;
        cur.next = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        if(searchPre(key)!=null){
            return true;
        }
        return false;
    }

    private Node searchPre(int key){
        Node pre = this.head;
        while(pre.next!=this.head){
           if(pre.next.data==key){
               return pre;
           }else{
               pre = pre.next;
           }
        }
        return null;
    }
    @Override
    public int remove(int key) {
        int old = 0;
        Node pre = searchPre(key);
        if(pre==null){
            System.out.println("无该节点");
        }
        old = pre.next.data;
        pre.next = pre.next.next;
        return old;
    }

    @Override
    public void removeAllKey(int key) {
        int old = 0;
        Node pre = this.head;
        Node cur = this.head;
        while(cur!=this.head){
            if(cur.data==key){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                cur = pre;
                cur = cur.next;
            }
        }
    }

    @Override
    public int getLength() {
       Node node = this.head.next;
       int count = 0;
       while(node!=this.head){
           count++;
       }
       return count;
    }

    @Override
    public void display() {
        Node node = this.head.next;
        int count = 0;
        while(node!=this.head){
            System.out.println(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while(this.head.next!=this.head){
            Node cur = this.head.next;
            this.head.next = cur.next;
            cur.next = null;
        }
    }
}
