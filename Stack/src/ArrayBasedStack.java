import java.util.NoSuchElementException;

public class ArrayBasedStack<E> implements Stack<E> {

    private E[] items;
    private int size;

    public ArrayBasedStack() {
        size = 0;
        items = (E[]) new Object[4];
    }

    private void resize(int newSize) {
        E[] temp = (E[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public void push(E item) {
        if (item == null) throw new IllegalArgumentException();
        if (size == items.length) resize(items.length * 2);
        items[size] = item;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException();
        E lastItem = items[size - 1];
        items[size - 1] = null;
        size--;
        if (size > 8 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return lastItem;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
