package algorithm;

public class NumberOfVisibleNodes {

    public static void main(String[] args) {

        Node root_1 = new Node(8);
        root_1.left = new Node(3);
        root_1.right = new Node(10);
        root_1.left.left = new Node(1);
        root_1.left.right = new Node(6);
        root_1.right.right = new Node(14);
        root_1.left.right.left = new Node(4);
        root_1.left.right.right = new Node(7);
        root_1.right.right.left = new Node(13);
        int expected_1 = 4;
        int output_1 = visibleNodes(root_1);
        System.out.println(output_1);


        Node root_2 = new Node(1);
        int output_2 = visibleNodes(root_2);
        System.out.println(output_2);

    }

    static int visibleNodes(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null)
            return findLHeight(root.left) + 1;
        else if (root.right != null)
            return findLHeight(root.right) + 1;

        return 1;
    }

    static int findLHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int lHeight = findLHeight(node.left) + 1;
        int rHeight = findLHeight(node.right) + 1;

        return Math.max(lHeight, rHeight);
    }


    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
