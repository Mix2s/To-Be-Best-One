package main.treePackge.Linktree.Tree;

public class Test {
    public static void main(String[] args) {
        String str = "abc##de#g##f###";
        TestTree testTree = new TestTree();
        TestTree.TreeNode treeNode = testTree.createPreTestTree(str);
        testTree.binaryTreePostOrder(treeNode);
        System.out.println();
        testTree.binaryTreePostOrder(treeNode);
        System.out.println();
        System.out.println(testTree.binaryTreeComplete(treeNode));
    }
}
