package trees;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessBinaryTree {

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
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(14);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        //root.right.left = new TreeNode(6);
      //  root.right.right = new TreeNode(7);

        System.out.println(isCompleteTree(root));

    }


    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        boolean foundNull = false;
        while (true) {
            int nodeCount = bfs.size();
            if (nodeCount == 0) {
                break;
            }
            while (nodeCount > 0) {
                TreeNode current = bfs.poll();

                if (current != null && foundNull) {
                    return false;
                }

                if (current == null) {
                    foundNull = true;
                } else {
                    bfs.add(current.left);
                    bfs.add(current.right);
                }
                nodeCount--;
            }
        }
        return true;
    }
}
