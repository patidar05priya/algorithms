package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Given a Binary Search Tree (BST) with root node root, and a target value V, split the tree into two subtrees where one subtree has nodes
 * that are all smaller or equal to the target value, while the other subtree has all nodes that are greater than the target value. It's not necessarily
 * the case that the tree contains a node with value V.
 * <p>
 * Additionally, most of the structure of the original tree should remain. Formally, for any child C with parent P in the original tree,
 * if they are both in the same subtree after the split, then node C should still have the parent P. You should output the root TreeNode
 * of both subtrees after splitting, in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [4,2,6,1,3,5,7], V = 2
 * Output: [[2,1],[4,3,6,null,null,5,7]]
 * Explanation:
 * Note that root, output[0], and output[1] are TreeNode objects, not arrays.
 * <p>
 * The given tree [4,2,6,1,3,5,7] is represented by the following diagram:
 * <p>
 * 4
 * /   \
 * 2      6
 * / \    / \
 * 1   3  5   7
 * <p>
 * while the diagrams for the outputs are:
 * <p>
 * 4
 * /   \
 * 3      6      and    2
 * / \          /
 * 5   7         1
 */
public class SplitBSTBasedOnTarget {
    TreeNode root;

    public static void main(String[] args) {
        SplitBSTBasedOnTarget splitBSTBasedOnTarget = new SplitBSTBasedOnTarget();
        splitBSTBasedOnTarget.root = new TreeNode(4);

        splitBSTBasedOnTarget.root.left = new TreeNode(2);
        splitBSTBasedOnTarget.root.left.left = new TreeNode(1);
        splitBSTBasedOnTarget.root.left.right = new TreeNode(3);

        splitBSTBasedOnTarget.root.right = new TreeNode(6);
        splitBSTBasedOnTarget.root.right.left = new TreeNode(5);
        splitBSTBasedOnTarget.root.right.right = new TreeNode(7);

        splitBSTBasedOnTarget.printLevelOrder(splitBSTBasedOnTarget.root);

        int target = 2;
        TreeNode[] ret = new TreeNode[]{null, null};

        splitBasedOnTarget(splitBSTBasedOnTarget.root, target, ret);

        System.out.println("first tree");
        splitBSTBasedOnTarget.printLevelOrder(ret[0]);

        System.out.println("Second tree");
        splitBSTBasedOnTarget.printLevelOrder(ret[1]);



    }

    private static void splitBasedOnTarget(TreeNode root, int target, TreeNode[] ret) {
        if (root == null) {
            return;
        }

        if (root.val <= target) {
            splitBasedOnTarget(root.right, target, ret);
            root.right = ret[0];
            ret[0] = root;
        } else {
            splitBasedOnTarget(root.left, target, ret);
            root.left = ret[1];
            ret[1] = root;
        }

    }


    /**
     * print level order
     *
     * @param root
     */
    void printLevelOrder(TreeNode root) {
        // Base Case
        if (root == null)
            return;

        // Create an empty queue for level order tarversal
        Queue<TreeNode> q = new LinkedList<>();

        // Enqueue Root and initialize height
        q.add(root);


        while (true) {

            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = q.size();
            if (nodeCount == 0)
                break;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0) {
                TreeNode node = q.peek();
                System.out.print(node.val + " ");
                q.remove();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.println();
        }
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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
}
