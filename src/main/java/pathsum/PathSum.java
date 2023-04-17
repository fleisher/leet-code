package pathsum;

class PathSum {
    public static void main(String[] args) {

//        TreeNode t41 = new TreeNode(7);
//        TreeNode t42 = new TreeNode(2);
//        TreeNode t43 = new TreeNode(1);
//
//        TreeNode t31 = new TreeNode(11, t41, t42);
//        TreeNode t32 = new TreeNode(13);
//        TreeNode t33 = new TreeNode(4, null, t43);
//
//        TreeNode t21 = new TreeNode(4, t31, null);
//        TreeNode t22 = new TreeNode(8, t32, t33);
//
//        TreeNode root = new TreeNode(5, t21, t22);

        TreeNode t21 = new TreeNode(2);

        TreeNode root = new TreeNode(1, t21, null);


        System.out.println(getPathSum(root, 0,1));
//        System.out.println(getPathSum(root, 22));

    }

// 5 4 11 7
    private static boolean getPathSum(TreeNode sheet, int currentSum, int targetSum) {
        boolean result = false;

        if (sheet.left != null) {
            result = getPathSum(sheet.left, currentSum + sheet.val, targetSum);
        }

        if (result) return result;

        if (sheet.right != null) {
            result = getPathSum(sheet.right, currentSum + sheet.val, targetSum);
        }

        if (result) return result;

        return currentSum !=0 && currentSum + sheet.val == targetSum;
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