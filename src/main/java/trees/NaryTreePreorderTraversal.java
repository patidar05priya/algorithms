package trees;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
    static Node root;

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", children=" + children +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Node> _children = new ArrayList<>();

        root = new Node(1);
        Node temp = new Node(3);
        _children.add(null);
        _children.add(temp);
        _children.add(new Node(2));
        _children.add(new Node(4));
        root.children = _children;


        _children = new ArrayList<>();
       _children.add(null);
        _children.add(new Node(5));
        _children.add(new Node(6));
        temp.children = _children;
        List<Integer> res = preorder(root);
        System.out.println(res);
    }


    static public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    static void postorder(Node root, List<Integer> res) {
        if (root.children == null) return;

        for (Node n : root.children) {
            if (n != null) {
                postorder(n, res);
                res.add(n.val);
            }
        }
    }
}
