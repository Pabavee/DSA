// LinkedListFIFOQueue.java
public class LinkedListFIFOQueue<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedListFIFOQueue() {
        front = rear = null;
        size = 0;
    }

    public void enqueue(T data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        Node oldFront = front;
        T data = front.data;
        front = front.next;
        oldFront.next = null; 

        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListFIFOQueue<Integer> queue = new LinkedListFIFOQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println("Queue size: " + queue.size());
        System.out.print("Queue front (peek): " + queue.peek() + "\n");

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        System.out.println("Queue after dequeues:");
        queue.display();

        System.out.println("Queue size now: " + queue.size());
    }
}
