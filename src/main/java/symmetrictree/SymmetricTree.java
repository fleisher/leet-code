package symmetrictree;

public class SymmetricTree {

    public void main(String[] args) {

        TreeNode t31 = new TreeNode(3);
        TreeNode t32 = new TreeNode(4);
        TreeNode t33 = new TreeNode(4);
        TreeNode t34 = new TreeNode(3);

        TreeNode t21 = new TreeNode(2, t31, t32);
        TreeNode t22 = new TreeNode(2, t33, t34);

        TreeNode root = new TreeNode(1, t21, t22);

        System.out.println(isSymmetric(root));

    }

    public class TreeNode {
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

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricLeftRight(root.left, root.right);
    }

    public boolean isSymmetricLeftRight(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        return left.val == right.val && isSymmetricLeftRight(left.left, right.right) && isSymmetricLeftRight(left.right, right.left);

    }
}
