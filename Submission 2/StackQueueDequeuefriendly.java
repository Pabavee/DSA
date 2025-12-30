package dsa.stackqueue;
import java.util.Stack;

public class StackQueueDequeueFriendly {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    // Enqueue operation 
    public void enqueue(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        System.out.println("Enqueued: " + x);
    }

    // Dequeue operation 
    public int dequeue() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int removed = s1.pop();
        System.out.println("Dequeued: " + removed);
        return removed;
    }

    // Display queue
    public void display() {
        System.out.println("Queue: " + s1);
    }

    public static void main(String[] args) {
        StackQueueDequeueFriendly q = new StackQueueDequeueFriendly();

        q.enqueue(3);
        q.enqueue(5);
        q.dequeue();   // removes 3
        q.enqueue(7);
        q.dequeue();   // removes 5
        q.dequeue();   // removes 7
    }
}
