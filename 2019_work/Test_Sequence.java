/**
 * Created by smyhvae on 2015/8/27.
 */

public class LinkList {

    private int size;
    private Node root; //定义一个根节点

    private int foot = 0;      // 操作返回数组的脚标
    private String[] retData;       // 返回数组
    private boolean changeFlag = true;
    // changeFlag == true：数据被更改了，则需要重新遍历
    // changeFlag == false：数据没有更改，不需要重新遍历


    //添加数据
    public boolean add(String data) {

        if (data == null) {     // 如果添加的是一个空数据，那增加失败
            return false;
        }

        // 将数据封装为节点，目的：节点有next可以处理关系
        Node newNode = new Node(data);
        // 链表的关键就在于根节点
        if (root == null) {  //如果根节点是空的，那么新添加的节点就是根节点。(第一次调用add方法时，根节点当然是空的了)
            root = newNode;
        } else {
            root.addNode(newNode);

        }

        this.size++;
        return true;

    }


    //方法：增加一组数据
    public boolean addAll(String data[]) {     // 一组数据
        for (int x = 0; x < data.length; x++) {
            if (!this.add(data[x])) { // 只要有一次添加不成功，那就是添加失败
                return false;
            }
        }
        return true;
    }

    //方法：删除数据
    public boolean remove(String data) { //要删除的节点，假设每个节点的data都不一样

        if (!this.contains(data)) { //要删除的数据不存在
            return false;
        }

        if (root != null) {
            if (root.data.equals(data)) {  //说明根节点就是需要删除的节点
                root = root.next;  //让根节点的下一个节点成为根节点，自然就把根节点顶掉了嘛（不像数组那样，要将后面的数据在内存中整体挪一位）
            } else {  //否则
                root.removeNode(data);
            }
        }
        size--;
        return true;

    }

    //输出所有节点
    public void print() {
        if (root != null) {
            System.out.print(root.data);
            root.printNode();
            System.out.println();
        }
    }


    //方法：获取全部数据
    public String[] toArray() {
        if (this.size == 0) {
            return null; // 没有数据
        }
        this.foot = 0;       // 清零
        this.retData = new String[this.size];     // 开辟数组大小
        this.root.toArrayNode();
        return this.retData;
    }


    //获取数据的长度
    public int size() {
        return this.size;
    }

    //判断是否为空链表
    public boolean isEmpty() {
        return this.size == 0;
    }

    //清空链表
    public void clear() {
        this.root = null;
        this.size = 0;
    }


    //查询数据是否存在
    public boolean contains(String data) {      // 查找数据
        // 根节点没有数据，查找的也没有数据
        if (this.root == null || data == null) {
            return false;        // 不需要进行查找了
        }
        return this.root.containsNode(data);        // 交给Node类处理
    }


    //方法：根据索引取得数据
    public String get(int index) {
        if (index > this.size) {         // 超过个数
            return null;          // 返回null
        }
        this.foot = 0;       // 操作foot来定义脚标
        return this.root.getNode(index);
    }


    //定义一个节点内部类（假设要保存的数据类型是字符串）
    //比较好的做法是，将Node定义为内部类，在这里面去完成增删、等功能，然后由LinkList去调用增、删的功能
    class Node {
        private String data;
        private Node next;  //next表示：下一个节点对象（单链表中）

        public Node(String data) {
            this.data = data;
        }

        //添加节点
        public void addNode(Node newNode) {

            //下面这段用到了递归，需要反复理解
            if (this.next == null) {   // 递归的出口：如果当前节点之后没有节点，说明我可以在这个节点后面添加新节点
                this.next = newNode;   //添加新节点
            } else {
                this.next.addNode(newNode);  //向下继续判断，直到当前节点之后没有节点为止

            }
        }


        //判断节点是否存在
        public boolean containsNode(String data) {      // 查找数据
            if (data.equals(this.data)) {     // 与当前节点数据吻合
                return true;
            } else {       // 与当前节点数据不吻合
                if (this.next != null) {   // 还有下一个节点
                    return this.next.containsNode(data);
                } else {       // 没有后续节点
                    return false;        // 查找不到
                }
            }
        }


        //删除节点
        public void removeNode(String data) {
            if (this.next != null) {
                if (this.next.data.equals(data)) {
                    this.next = this.next.next;
                } else {
                    this.next.removeNode(data);
                }
            }

        }

        //输出所有节点
        public void printNode() {
            if (this.next != null) {
                System.out.print("-->" + this.next.data);
                this.next.printNode();
            }
        }

        //获取全部数据
        public void toArrayNode() {
            LinkList.this.retData[LinkList.this.foot++] = this.data;
            if (this.next != null) {
                this.next.toArrayNode();
            }
        }


        //根据索引位置获取数据
        public String getNode(int index) {
            if (LinkList.this.foot++ == index) {     // 当前索引为查找数值
                return this.data;
            } else {
                return this.next.getNode(index);
            }
        }


    }
}
