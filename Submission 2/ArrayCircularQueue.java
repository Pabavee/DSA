package dsa.queue;

public class ArrayCircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    // Constructor
    public ArrayCircularQueue(int size) {
        capacity = size;
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    // Add elements
    public void enqueue(int value) {
        if ((rear + 1) % capacity == front) {
            System.out.println("[X] Sorry, the queue is full!");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        System.out.println("[+] Added to queue → " + value);
    }

    // Remove elements
    public int dequeue() {
        if (front == -1) {
            System.out.println("[!] Nothing to remove, queue is empty.");
            return -1;
        }

        int removed = queue[front];

        if (front == rear) {
            front = -1;
            rear = -1;
            System.out.println("[-] Removed last item → " + removed + " (queue reset)");
        } else {
            System.out.println("[-] Removed from front → " + removed);
            front = (front + 1) % capacity;
        }
        return removed;
    }

    // Show queue
    public void display() {
        if (front == -1) {
            System.out.println("[Queue Status] → EMPTY");
            return;
        }

        System.out.print("[Queue Items] → ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayCircularQueue cq = new ArrayCircularQueue(4);

        cq.enqueue(8);
        cq.enqueue(12);
        cq.enqueue(6);
        cq.display();

        cq.dequeue();
        cq.enqueue(20);
        cq.display();

        cq.dequeue();
        cq.dequeue();
        cq.display();

        cq.dequeue(); // empty condition test
        cq.enqueue(5);
        cq.enqueue(15);
        cq.enqueue(25);
        cq.enqueue(35); // overflow test
        cq.display();
    }
}
