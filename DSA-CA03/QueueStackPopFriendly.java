import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPopFriendly {
    Queue<Integer> q = new LinkedList<>();

    // Push is O(n)
    public void push(int x) {
        q.add(x);
        int size = q.size();
        while (size > 1) {
            q.add(q.remove());
            size--;
        }
    }

    // Pop is O(1)
    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.remove();
    }

    public static void main(String[] args) {
        QueueStackPopFriendly stack = new QueueStackPopFriendly();
        stack.push(5);
        stack.push(15);
        stack.push(25);

        System.out.println(stack.pop()); // 25
        System.out.println(stack.pop()); // 15
    }
}
