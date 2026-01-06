// LinkedListStack.java
public class LinkedListStack<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node top;
    private int size;

    public LinkedListStack() {
        top = null;
        size = 0;
    }

    public void push(T data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Node oldTop = top;
        T data = top.data;
        top = top.next;
        oldTop.next = null; 
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListStack<String> stack = new LinkedListStack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Stack size: " + stack.size());
        System.out.println("Top value (peek): " + stack.peek());

        System.out.println("Popped: " + stack.pop());
        System.out.println("After pop, stack:");
        stack.display();

        System.out.println("Stack size now: " + stack.size());
    }
}
