package mergetwobinarytrees;

class Solution {
    public static void main(String[] args) {
        TreeNode t131 = new TreeNode(5);
        TreeNode t121 = new TreeNode(3, t131, null);
        TreeNode t122 = new TreeNode(2);

        TreeNode root1 = new TreeNode(1, t121, t122);

        TreeNode t231 = new TreeNode(4);
        TreeNode t232 = new TreeNode(7);
        TreeNode t221 = new TreeNode(4, null, t231);
        TreeNode t222 = new TreeNode(3, null, t232);

        TreeNode root2 = new TreeNode(2, t221, t222);

        TreeNode res = mergeTrees(root1, root2);

    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) { return root2; }
        if (root2 == null) { return root1; }


        return new TreeNode(root1.val + root2.val, mergeTrees(root1.left, root2.left), mergeTrees(root1.right, root2.right));
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
