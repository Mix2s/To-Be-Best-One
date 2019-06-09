//package everyday;
//
//import javax.swing.tree.TreeNode;
//
//public class day692 {
//    public void Mirror(TreeNode root){
//        reverseTree(root);
//    }
//
//    private void reverseTree(TreeNode root) {
//        if(root==null){
//            return;
//        }
//        swap(root);
//        reverseTree(root.left);
//        reverseTree(root.right);
//    }
//
//    private void swap(TreeNode root) {
//        TreeNode node = null;
//        node = root.left;
//        root.right = node;
//    }
//}
