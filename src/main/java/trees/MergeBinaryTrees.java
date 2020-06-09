package trees;

import java.util.Queue;

public class MergeBinaryTrees {
    static TreeNode root1;
    static TreeNode root2;

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
        root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);

        root1.left.left = new TreeNode(5);


        root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);

        TreeNode root = mergeTrees(root1, root2);

    }

    static TreeNode result = null;

    static public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        result = null;
        mergeTreesUtil(t1, t2);
        return t1;
    }

    static public void mergeTreesUtil(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return;
        }


        t1.val = t1.val + t2.val;
        mergeTreesUtil(t1.left, t2.left);
        mergeTreesUtil(t1.right, t2.right);
        if (t1.right == null ) {
            t1.right = t2.right;
        }
        if (t1.left == null ) {
            t1.left = t2.left;
        }
    }




}
