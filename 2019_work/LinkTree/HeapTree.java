package main.Tree;

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
    int getSize(TreeNode root){
        if(root==null){
            return 0;
        }
         return getSize(root.left)+getSize(root.rigth)+1;
    }

    // 叶子结点个数
    int getLeafSize(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.rigth==null){
            return 1;
        }
        return getLeafSize(root.left)+getLeafSize(root.rigth);
    }

    // 第 k 层结点个数
    int getKLevelSize(TreeNode root, int k){
        if(root==null){
            return 0;
        }
        if(k==0){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.rigth,k-1);
    }

    // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，如果找到，返回结点，否则返回 null
  /* public static String str = "";
    TreeNode find(TreeNode root, int value){
       if(root==null){
           return null;
       }
       str+=find(root.left,value);
       str+=find(root.rigth,value);
       if(!str.contains(value+"")){
           return ;
       }

    }*/
    //二叉树的高度
    int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = height(root.left)+1;
        int right = height(root.rigth)+1;
        return (left>right)?left:right;
    }
    //二叉树的前序遍历
    void binaryTreePrevOrder(TreeNode root){
        if(root==null){
            return ;
        }
        System.out.print(root.val+" ");
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.rigth);
    }
    //二叉树的中序遍历
    void binaryTreeInOrder(TreeNode root){
        if(root==null){
            return;
        }
        binaryTreeInOrder(root.left);
        System.out.print(root.val+" ");
        binaryTreeInOrder(root.rigth);
    }
    //二叉树的后序遍历
    void binaryTreePostOrder(TreeNode root){
        if(root==null){
            return;
        }
        binaryTreeInOrder(root.left);
        binaryTreeInOrder(root.rigth);
        System.out.print(root.val+" ");
    }

    }

