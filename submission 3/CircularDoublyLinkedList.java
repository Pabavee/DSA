// CircularDoublyLinkedList.java
public class CircularDoublyLinkedList<T> {

    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public CircularDoublyLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // Add at the end (tail)
    public void add(T data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node tail = head.prev;

            newNode.next = head;
            newNode.prev = tail;

            tail.next = newNode;
            head.prev = newNode;
        }
        size++;
    }

    // Add at specific position (0-based index)
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == size) {
            add(data);
            return;
        }

        Node current = getNodeAt(index);
        Node newNode = new Node(data);
        Node prevNode = current.prev;

        prevNode.next = newNode;
        current.prev = newNode;

        newNode.prev = prevNode;
        newNode.next = current;

        if (index == 0) {
            head = newNode;
        }

        size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node toRemove = getNodeAt(index);
        T data = toRemove.data;

        if (size == 1) {
            head = null;
        } else {
            toRemove.prev.next = toRemove.next;
            toRemove.next.prev = toRemove.prev;

            if (index == 0) {
                head = toRemove.next;
            }
        }
        size--;
        return data;
    }

    private Node getNodeAt(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void displayForward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }

    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node current = head.prev;
        Node start = head.prev;

        do {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        } while (current != start);

        System.out.println("(back to tail)");
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>();

        // Test add at tail
        list.add(10);
        list.add(20);
        list.add(30);

        // Test insert at index
        list.add(0, 5);   
        list.add(2, 15);  

        System.out.println("Forward Display:");
        list.displayForward();

        System.out.println("Backward Display:");
        list.displayBackward();

        // Test remove
        System.out.println("Removed index 0: " + list.remove(0));
        System.out.println("Removed index 2: " + list.remove(2));

        System.out.println("After removals (Forward):");
        list.displayForward();

        System.out.println("After removals (Backward):");
        list.displayBackward();

        System.out.println("Size: " + list.size());
    }
}
