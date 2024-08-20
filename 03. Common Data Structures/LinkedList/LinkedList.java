package LinkedList;

import java.util.ArrayList;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

}

public class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {

    }

    public int get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        if (head != null) {
            Node oldHead = head;
            head = node;
            head.next = oldHead;
        } else {
            head = node;
            tail = head;
        }

    }

    public void insertTail(int val) {
        Node node = new Node(val);
        tail.next = node;
        tail = node;
    }

    public boolean remove(int index) {
        Node node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        if (node.next != null) {
            node.next = node.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node node = head;
        while (node != null) {
            values.add(node.value);
            node = node.next;
        }
        return values;
    }
}
