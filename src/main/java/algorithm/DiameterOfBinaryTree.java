package algorithm;

public class DiameterOfBinaryTree {

    static TreeNode root;

    static class Result {
        int res;
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(diameterOfBinaryTree(root));
    }


    static public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Result res = new Result();
        res.res = Integer.MIN_VALUE;
        diameterOfBinaryTreeutil(root, res);
        return res.res;
    }

    static public int diameterOfBinaryTreeutil(TreeNode root, Result res) {
        int l = 0;
        int r = 0;
        if (root.left != null)
            l = diameterOfBinaryTreeutil(root.left, res) + 1;
        if (root.right != null)
            r = diameterOfBinaryTreeutil(root.right, res) + 1;
        res.res = Math.max(res.res, l + r);
        return Math.max(l, r);

    }
}
