package algorithm;

/**
 * Given a Binary Tree, find if there exist edge whose removal creates two trees of equal size.
 */
public class DivideTreeInTwoHalf {
    Node root;

    public static void main(String[] args) {
        DivideTreeInTwoHalf tree = new DivideTreeInTwoHalf();
        tree.root = new Node(5);
        tree.root.left = new Node(1);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(3);
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
        int numOfNodes = count(node);

        return checkUtil(node, numOfNodes);
    }

    boolean checkUtil(Node node, int n) {
        if (node == null) {
            return false;
        }


        if (count(node) == n - count(node)) {
            return true;
        }

        return checkUtil(node.left, n) || checkUtil(node.right, n);
    }

    int count(Node node) {
        if (node == null) {
            return 0;
        }
        return (count(node.left) + count(node.right) + 1);
    }
    //###############################################################################################

    class Result {
        boolean res;

        Result() {
            this.res = false;
        }
    }

    /**
     * complexity : O(n) : n == number no nodes
     *
     * @param node Node
     * @return boolean
     */
    //###############################################################################################
    private boolean checkB(Node node) {
        int numOfNodes = count(node);
        Result res = new Result();
        checkUtilB(node, numOfNodes, res);
        return res.res;
    }

    int checkUtilB(Node node, int n, Result result) {
        // base condition
        if (node == null) {
            return 0;
        }

        int size = checkUtilB(node.left, n, result) + checkUtilB(node.right, n, result) + 1;

        if (size == n - size) {
            result.res = true;
        }

        return size;

    }


    //###############################################################################################
   static  class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }
}


