package trees;

public class BinaryTreeColoringGame {
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

    }

    public static void main(String[] args) {

        root = new TreeNode(1);

        root.left = new TreeNode(2);
     //   root.left.left = new TreeNode(4);
      //  root.left.left.left = new TreeNode(14);
      //  root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);

        System.out.println(btreeGameWinningMove(root, 5, 4));


    }

    static TreeNode res = null;

    static public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (n == 0) {
            return false;
        }

        if (x == root.val) {
            int left = getNoOfNodes(root.left);
            int right = getNoOfNodes(root.right);
            return left != right;
        }

        res = null;
        int total = getNoOfNodes(root);
        getNoOfNodes(root, x);
        int fromRed = getNoOfNodes(res);

        return total - fromRed > fromRed;

    }

    static void getNoOfNodes(TreeNode node, int x) {
        if (node == null) return;
        if (node.val == x) {
            res = node;
            return;
        }
        getNoOfNodes(node.left, x);
        getNoOfNodes(node.right, x);

    }

    static int getNoOfNodes(TreeNode node) {
        if (node == null) return 0;

        int l = getNoOfNodes(node.left) + 1;
        return getNoOfNodes(node.right) + l;
    }


}
