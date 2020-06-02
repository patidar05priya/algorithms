package trees;

public class CountGoodNodesBinaryTree {
    static TreeNode root;

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;

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
        root = new CountGoodNodesBinaryTree.TreeNode(2);
        root.right = new CountGoodNodesBinaryTree.TreeNode(4);
        root.right.left = new CountGoodNodesBinaryTree.TreeNode(10);
        root.right.right = new CountGoodNodesBinaryTree.TreeNode(8);
        root.right.right.left = new CountGoodNodesBinaryTree.TreeNode(4);
        root.right.right.left.right = new CountGoodNodesBinaryTree.TreeNode(5);
        System.out.println(goodNodes(root));
    }

    static class Result {
        int res;
    }


    static int goodNodes(TreeNode root) {
        if (root == null) return 0;
        int rootValue = root.val;
        Result res = new Result();
        res.res = 0;
        goodNodesUtil(root, rootValue, rootValue, res);

        return res.res;
    }

    static void goodNodesUtil(TreeNode root, int rootValue, int current, Result res) {
        if (root == null) {
            return;
        }

        if (root.val >= rootValue && root.val >= current) {
            current = root.val;
            res.res++;
            System.out.println(root.val);

        }

        goodNodesUtil(root.left, rootValue, current, res);
        goodNodesUtil(root.right, rootValue, current, res);
    }

}
