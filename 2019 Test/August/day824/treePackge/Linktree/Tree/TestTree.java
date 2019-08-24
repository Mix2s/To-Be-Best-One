package main.treePackge.Linktree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestTree {
    class TreeNode {
        char val;
        TreeNode left;
        TreeNode rigth;

        public TreeNode(char val) {
            this.val = val;
            this.left = left;
            this.rigth = rigth;
        }
    }

    static int prei = 0;

    //前序遍历创建二叉树
    TreeNode createPreTestTree(String s) {
        TreeNode root = null;
        if (s.charAt(prei) != '#') {
            root = new TreeNode(s.charAt(prei));
            prei++;
            root.left = createPreTestTree(s);
            root.rigth = createPreTestTree(s);
        } else {
            prei++;
        }

        return root;
    }

    // 结点个数
    int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSize(root.left) + getSize(root.rigth) + 1;
    }

    // 叶子结点个数
    int getLeafSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.rigth == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.rigth);
    }

    // 第 k 层结点个数
    int getKLevelSize(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.rigth, k - 1);
    }

    // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，如果找到，返回结点，否则返回 null
    public static String str = "";

    TreeNode find(TreeNode root, char value) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            return root;
        }
        TreeNode r = find(root.left, value);
        if (r != null) {
            return r;
        }
        r = find(root.rigth, value);
        if (r != null) {
            return r;
        }
        return null;
    }

    //二叉树的高度
    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left) + 1;
        int right = height(root.rigth) + 1;
        return (left > right) ? left : right;
    }

    //二叉树的前序遍历
    void binaryTreePrevOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.rigth);
    }

    //二叉树前序遍历非递归
    void binaryTreePreOrderNonR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;
            }

            TreeNode top = stack.pop();
            cur = top.rigth;
        }
    }

    //二叉树的中序遍历
    void binaryTreeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        binaryTreeInOrder(root.left);
        System.out.print(root.val + " ");
        binaryTreeInOrder(root.rigth);
    }

    //二叉树的中序遍历非递归
    void binaryTreeInOrderNonR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            System.out.println(top.val);
            cur = top.rigth;
        }
    }


        //二叉树的后序遍历
        void binaryTreePostOrder (TreeNode root){
            if (root == null) {
                return;
            }
            binaryTreeInOrder(root.left);
            binaryTreeInOrder(root.rigth);
            System.out.print(root.val + " ");
        }

    //二叉树的后序遍历非递归
    void binaryTreePostOrderNonR (TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.rigth==null||cur.rigth==prev){
                System.out.print(cur.val+" ");
                stack.pop();
                prev = cur;
                cur = null;
            }else{
                cur = cur.rigth;
            }
        }

    }

    void binaryTreeLevelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();

        if(root!=null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.rigth!=null){
                queue.offer(cur.rigth);
            }
        }
    }

    //判断是不是完全二叉树
    int binaryTreeComplete(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.rigth);
            } else {
                break;
            }
        }
        while(!queue.isEmpty()){
            TreeNode top = queue.peek();
            if(top==null){
                queue.poll();
            }else{
                return 1;  //不是完全二叉树
            }
        }
        return 0;  //执行完毕 到底 为完全二叉树
    }
}


