import innerClass.TreeNode;

public class TreeSolution {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeSolution treeSolution = new TreeSolution();
        TreeNode treeNode1 = new TreeNode(2);
        //treeSolution.mergeTrees();
    }

    //leetCode 617
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2){
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        TreeNode ansNode = new TreeNode(root1.val + root2.val);
        ansNode.left = mergeTrees(root1.left,root2.left);
        ansNode.right = mergeTrees(root1.right,root2.right);
        return ansNode;
    }
}
