import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly {
    Queue<Integer> q = new LinkedList<>();

    // Push is O(1)
    public void push(int x) {
        q.add(x);
    }

    // Pop is O(n)
    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        int size = q.size();
        while (size > 1) {
            q.add(q.remove());
            size--;
        }
        return q.remove();
    }

    public static void main(String[] args) {
        QueueStackPushFriendly stack = new QueueStackPushFriendly();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop()); // 30
        System.out.println(stack.pop()); // 20
    }
}
