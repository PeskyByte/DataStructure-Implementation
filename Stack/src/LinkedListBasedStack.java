import java.util.NoSuchElementException;

public class LinkedListBasedStack<E> implements Stack<E>{
    private Node<E> top;
    private int size;

    public LinkedListBasedStack() {
        size = 0;
        top = null;
    }

    @Override
    public void push(E item) {
        if (item == null) throw new IllegalArgumentException();
        Node<E> newHead = new Node<E>(item);
        newHead.setNext(top);
        this.top = newHead;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException();
        E popped = top.getItem();
        top = top.getNext();
        size--;
        return popped;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
