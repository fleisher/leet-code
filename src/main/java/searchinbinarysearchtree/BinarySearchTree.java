package searchinbinarysearchtree;

public class BinarySearchTree {
    public static void main(String[] args) {
        int val = 2;

        TreeNode t31 = new TreeNode(1);
        TreeNode t32 = new TreeNode(3);

        TreeNode t21 = new TreeNode(2, t31, t32);
        TreeNode t22 = new TreeNode(7);

        TreeNode root = new TreeNode(4, t21, t22);


        System.out.println(searchBST(root, val));

    }
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (val < root.val) { return searchBST(root.left, val); }
        return searchBST(root.right, val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
