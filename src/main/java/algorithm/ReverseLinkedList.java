package algorithm;

public class ReverseLinkedList {

    static ListNode head;

    static class ListNode {

        int data;
        ListNode next;

        ListNode(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new ListNode(85);
        list.head.next = new ListNode(15);
        list.head.next.next = new ListNode(4);
        list.head.next.next.next = new ListNode(20);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverseList(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }

    public ListNode reverseList(ListNode node) {
        if (node == null) return null;
        ListNode newList = null;
        while (node != null) {
            ListNode temp = new ListNode(node.data);
            temp.next = newList;
            newList = temp;
            node = node.next;


        }
        return newList;

    }

    // prints content of double linked list
    void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
