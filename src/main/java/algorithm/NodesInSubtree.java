package algorithm;

import java.util.*;

public class NodesInSubtree {
    static int priya = 1;

    // Tree Node
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Query {
        int v;
        char c;

        Query(int v, char c) {
            this.v = v;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        String s_2 = "abaacab";
        Node root_2 = new Node(1);
        root_2.children.add(new Node(2));
        root_2.children.add(new Node(3));
        root_2.children.add(new Node(7));
        root_2.children.get(0).children.add(new Node(4));
        root_2.children.get(0).children.add(new Node(5));
        root_2.children.get(1).children.add(new Node(6));
        ArrayList<Query> queries_2 = new ArrayList<>();
        queries_2.add(new Query(1, 'a'));
        queries_2.add(new Query(2, 'b'));
        queries_2.add(new Query(3, 'a'));

        System.out.println(Arrays.toString(countSubtreeImproved(root_2, queries_2, s_2)));

        System.out.println(priya);
    }


    static int[] countSubtreeImproved(Node root, ArrayList<Query> queries, String s) {
        int queryLength = queries.size();
        int[] result = new int[queryLength];
        Map<Character, Integer>[] map = new HashMap[s.length() + 1];
        for (int i = 1; i < s.length() + 1; i++) {
            priya++;

            map[i] = new HashMap<>();
        }
        countSubtreeImprovedUtil(root, map, null, s);

        for (int i = 0; i < queryLength; i++) {
            priya++;

            Map<Character, Integer> temp = map[queries.get(i).v];
            result[i] = temp.get(queries.get(i).c);
        }
        return result;
    }

    static void countSubtreeImprovedUtil(Node node, Map<Character, Integer>[] map, Node parent, String s) {
        map[node.val].put(s.charAt(node.val - 1), 1);
        for (Node node1 : node.children) {
            priya++;

            countSubtreeImprovedUtil(node1, map, node, s);
            mergeMaps(node1.val, node.val, map);
        }


    }

    static void mergeMaps(int parent, int child, Map<Character, Integer>[] map) {
        Map<Character, Integer> tempParent = map[parent];
        Map<Character, Integer> tempChild = map[child];

        for (Map.Entry<Character, Integer> entry : tempParent.entrySet()) {
            priya++;
            if (tempChild.containsKey(entry.getKey())) {
                tempChild.put(entry.getKey(), tempChild.get(entry.getKey()) + entry.getValue());
            } else {
                tempChild.put(entry.getKey(), entry.getValue());
            }
        }
        map[child] = tempChild;
    }

    //################# BRUTE FORCE START #############################
    static int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        Map<Character, Integer>[] list = new HashMap[s.length() + 1];
        int[] result = new int[queries.size()];
        for (int i = 1; i < s.length() + 1; i++) {
            list[i] = new HashMap<>();
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            getMetrics(current, list, s);
            queue.addAll(current.children);
        }

        for (int i = 0; i < queries.size(); i++) {
            result[i] = list[queries.get(i).v].get(queries.get(i).c);
        }
        return result;
    }


    static void getMetrics(Node node, Map<Character, Integer>[] list, String s) {
        if (node == null) {
            return;
        }
        Map<Character, Integer> map;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {

            Node current = queue.remove();
            map = list[node.val];
            if (map.containsKey(s.charAt(current.val - 1))) {
                int count = map.get(s.charAt(current.val - 1));
                count++;
                map.put(s.charAt(current.val - 1), count);
            } else {
                map.put(s.charAt(current.val - 1), 1);
            }

            queue.addAll(current.children);
        }
    }
    //################# BRUTE FORCE START #############################


}
