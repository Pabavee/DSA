package dsa.linkedlist;

public class SinglyLinkedList {

    class Node {
        int value;
        Node link;

        Node(int value) {
            this.value = value;
            this.link = null;
        }
    }

    private Node head;

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            System.out.println("[Start] First item added → " + value);
            return;
        }

        Node t = head;
        while (t.link != null) {
            t = t.link;
        }
        t.link = node;
        System.out.println("[End] Item inserted → " + value);
    }

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        node.link = head;
        head = node;
        System.out.println("[Front] New head is now → " + value);
    }

    public void delete(int target) {
        if (head == null) {
            System.out.println("[Oops] Can't delete, list has nothing.");
            return;
        }

        if (head.value == target) {
            head = head.link;
            System.out.println("[Head Removed] " + target + " was the first node.");
            return;
        }

        Node t = head;
        while (t.link != null && t.link.value != target) {
            t = t.link;
        }

        if (t.link == null) {
            System.out.println("[Not Found] " + target + " is not in the list.");
        } else {
            t.link = t.link.link;
            System.out.println("[Deleted] Node removed → " + target);
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("[List] EMPTY");
            return;
        }

        System.out.print("[List] ");
        Node t = head;
        while (t != null) {
            System.out.print(t.value + " ↦ ");
            t = t.link;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.display();

        list.insertAtBeginning(5);
        list.display();

        list.delete(20);
        list.display();
    }
}
