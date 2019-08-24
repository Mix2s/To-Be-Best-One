package main.DoubleLinked;

public class DoubleLinkedImpl implements IDoubleLinked{
    class Node{
        private int data;
        private Node prev;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head;
    private Node last;
    public DoubleLinkedImpl(){
        this.head = null;
        this.last = null;
    }
    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head==null){
            this.head = node;
            this.last = node;
        }else{
            node.next = this.head;
            node.next.prev = node;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head==null){
            this.head = node;
            this.head = node;
        }else{
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    private void checkIndex(int index){
        if(index<0||index>getLength()){
            throw new IndexOutOfBoundsException("下标不合法");
        }
    }
    private Node searchIndex(int index){
        checkIndex(index);
        Node cur = this.head;
        int count=0;
        while (count<index){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    @Override
    public boolean addindex(int index, int data) {
        Node node = new Node(data);
        Node cur = searchIndex(index);
        if(index==0){
            addFirst(data);
            return true;
        }
        if(index==getLength()){
            addLast(index);
            return true;
        }
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
        return true;
    }


    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur!=null){
            if(cur.next.data==key){
                return true;
            }else{
                cur = cur.next;
            }
        }
        return false;
    }

    @Override
    public int remove(int key) {
        Node cur = this.head;
        int oldData = 0;
        while(cur!=null){
            if(cur.data==key){
                oldData = key;
                if(cur==this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else{
                    cur.prev.next = cur.next;
                    if(cur.next!=null){
                        cur.next.prev = cur.prev;
                    }else{
                        this.last = cur.prev;
                    }
                }
                return oldData;
            }
            cur = cur.next;
        }
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        Node cur = this.head.next;
        while(cur!=null){
            if(cur==this.head){
                this.head = this.head.next;
                this.head.prev = null;
            }else{
                cur.prev.next = cur.next;
                if(cur!=null){
                    cur.next.prev = cur.prev;
                }else{
                    this.last = cur.prev;
                }
            }
        }
        cur = cur.next;
    }

    @Override
    public int getLength() {
        Node cur = this.head;
        int count = 0;
        while(cur!=null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while(cur!=null){
            System.out.println(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while(this.head!=null){
            Node cur = this.head.next;
            head.prev = null;
            head.next = null;
            head = cur;
        }
        this.last = null;
    }
}
