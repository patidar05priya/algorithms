package algorithm;

/**
 * Given a Binary Tree, find if there exist edge whose removal creates two trees of equal size.
 */
public class DivideTreeInTwoHalfOfEqualSum {
    Node root;

    public static void main(String[] args) {
        DivideTreeInTwoHalfOfEqualSum tree = new DivideTreeInTwoHalfOfEqualSum();
        tree.root = new Node(5);
        tree.root.left = new Node(1);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(23);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(4);
        if (tree.checkB(tree.root))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    /**
     * complexity : O(n^2) : n == number no nodes
     *
     * @param node Node
     * @return boolean
     */
    //###############################################################################################
    private boolean check(Node node) {
        int sum = getTotalSum(node, 0);
        System.out.println(sum);
        return checkUtil(node, sum);
    }

    boolean checkUtil(Node node, int sum) {
        if (node == null) {
            return false;
        }
        if (getTotalSum(node, 0) == sum - getTotalSum(node, 0)) {
            return true;
        }

        return checkUtil(node.left, sum) || checkUtil(node.right, sum);
    }

    /**
     * GET NODE COUNT
     *
     * @param node Node
     * @param sum  int
     * @return int
     */
    int getTotalSum(Node node, int sum) {
        if (node == null) {
            return 0;
        }

        return sum + node.key + getTotalSum(node.left, sum) + getTotalSum(node.right, sum);
    }
    //###############################################################################################


    /**
     * complexity : O(n) : n == number no nodes
     *
     * @param node Node
     * @return boolean
     */
    //###############################################################################################
    private boolean checkB(Node node) {
        int sum = getTotalSum(node, 0);
        System.out.println(sum);
        Result res = new Result();
        checkUtilB(node, sum, res, 0);
        return res.res;
    }

    int checkUtilB(Node node, int sum, Result result, int tempSum) {
        // base condition
        if (node == null) {
            return 0;
        }

        tempSum = tempSum + node.key + checkUtilB(node.left, sum, result, tempSum) +
                checkUtilB(node.right, sum, result, tempSum);

        if (tempSum == sum - tempSum) {
            result.res = true;
        }
        return tempSum;

    }

    class Result {
        boolean res;

        Result() {
            this.res = false;
        }
    }

    //###############################################################################################

    static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }
}


