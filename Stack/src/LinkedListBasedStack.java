import java.util.NoSuchElementException;

public class LinkedListBasedStack<E> {
    private Node<E> top;
    private int size;

    public LinkedListBasedStack() {
        size = 0;
        top = null;
    }

    public void push(E item) {
        if (item == null) throw new IllegalArgumentException();
        Node<E> newHead = new Node<E>(item);
        newHead.setNext(top);
        this.top = newHead;
        size++;
    }

    public E pop() {
        if (isEmpty()) throw new NoSuchElementException();
        E popped = top.getItem();
        top = top.getNext();
        size--;
        return popped;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
