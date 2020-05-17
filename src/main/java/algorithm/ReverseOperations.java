package algorithm;

public class ReverseOperations {
    public static void main(String[] args) {
        int[] arr_1 = { 2, 18, 24, 3, 5, 7, 9, 6, 12};
        int[] expected1 = {1, 8, 2, 9, 16, 12};
        Node head_1 = createLinkedList(arr_1);

        Node output_1 = reverse(head_1);
        printLinkedList(output_1);
        System.out.println("");
    }

    static Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    static void printLinkedList(Node head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
            if (head != null)
                System.out.print(" ");
        }
        System.out.print("]");
    }
   static  Node t = null;

    // Add any helper functions you may need here
    static Node reverse(Node head) {
        if (head == null) {
            return null;
        }

        Node tempHead = head;
        Node pre = null;
        Node newNode = null;

        while (tempHead != null) {
            if (tempHead.data % 2 == 0 || tempHead.next == null) {
                if (newNode == null) {
                    newNode = new Node(tempHead.data);
                } else {
                    Node temp = new Node(tempHead.data);
                    temp.next = newNode;
                    newNode = temp;
                    if (pre != null) {
                        pre.next = newNode;
                        newNode = pre;
                    }
                }
            } else {
                pre = tempHead;
                t = merge(newNode, tempHead);
                newNode = null;
            }
            tempHead = tempHead.next;
        }
        return t;
    }

    static Node merge(Node newNode, Node oldNode) {

        if (newNode == null) {
            return t;
        }
        Node temp = newNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = oldNode;

        return newNode;
    }
}
